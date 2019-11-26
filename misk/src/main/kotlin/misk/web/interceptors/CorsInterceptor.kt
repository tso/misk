package misk.web.interceptors

import misk.Action
import misk.web.NetworkChain
import misk.web.NetworkInterceptor
import misk.web.WebConfig
import javax.inject.Inject

internal class CorsInterceptor @Inject constructor(
  private val cors_allowed_origins: String
) : NetworkInterceptor {
  override fun intercept(chain: NetworkChain) {
    chain.httpCall.setResponseHeader("Access-Control-Allow-Origin", cors_allowed_origins)
    chain.proceed(chain.httpCall)
  }

  class Factory @Inject constructor(
    private val webConfig: WebConfig
  ) : NetworkInterceptor.Factory {
    override fun create(action: Action): NetworkInterceptor? {
      return CorsInterceptor(webConfig.cors_allowed_origins)
    }
  }
}
