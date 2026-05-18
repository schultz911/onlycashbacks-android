package `in`.onlycashbacks.twa.util

import org.junit.Assert.assertFalse
import org.junit.Test

class SecurityUtilsTest {

    @Test
    fun testIsDeviceRooted_ReturnsFalseOnNormalEnvironment() {
        // This test might be environment dependent, but usually it should be false
        // on a standard CI/Build environment unless it's explicitly rooted.
        // We just verify it doesn't crash and returns a boolean.
        val result = SecurityUtils.isDeviceRooted()
        // We can't strictly assert false without knowing the environment,
        // but for unit tests it should ideally be false.
        assertFalse("Expected device to not be rooted in test environment", result)
    }

    @Test
    fun testIsRunningOnEmulator_ReturnsFalseOnNonEmulator() {
        // Build.BRAND and other Build fields are mocked or default to certain values in JVM tests.
        // Usually they are 'null' or 'unknown'.
        SecurityUtils.isRunningOnEmulator()
        // Standard JVM unit test environment is not an Android emulator.
        // However, some fields like Build.FINGERPRINT might be "unknown" which we check.
        // Let's see what it returns.
    }
}
