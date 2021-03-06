package misk.feature

object FeatureFlagValidation {

  /**
   * Validates the feature flags's hashing "key". Most implementation technically support arbitrary
   * strings, but we still prefer to restrict valid input to prevent accidentally passing
   * in the wrong value or potentially sensitive information.
   */
  fun checkValidKey(feature: Feature, key: String) {
    require(key.isNotEmpty()) { "Key to flag $feature must not be empty" }
    require(match.matches(key)) { "Key to flag $feature can only contain alphanumeric characters, -, . and +" }
  }

  private val match = Regex("[a-zA-Z0-9_.-]+")
}
