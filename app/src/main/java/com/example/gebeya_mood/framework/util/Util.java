package com.example.gebeya_mood.framework.util;

import android.util.Log;

/**
 * Utility class for common functionality, such as logging data out.
 */
public final class Util {

    /**
     * Debug tag for logging and filtering our application.
     */
    private static final String TAG = "GEBEYA-MOOD-TAG-DEBUG";

    /**
     * Log a normal debug message
     */
    public static void d(Object source, String message) {
        log(source, message, false);
    }

    /**
     * Log a normal error message
     */
    public static void e(Object source, String message) {
        log(source, message, true);
    }

    /**
     * Helper method for logging out the data.
     */
    private static void log(Object source, String message, boolean isError) {
        final String name = source.getClass().getSimpleName();
        final String output = name + " : " + message;

        if (isError) {
            Log.e(TAG, output);
        } else {
            Log.d(TAG, output);
        }
    }
}
