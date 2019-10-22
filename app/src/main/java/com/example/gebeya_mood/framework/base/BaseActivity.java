package com.example.gebeya_mood.framework.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gebeya_mood.framework.util.Util;


/**
 * Base Activity to contain and hold most of the code that we would like to reuse from app to app.
 * This includes things such as logging messages and showing toast messages.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("< -------------------- onCreate(Bundle) -------------------- >");
    }

    @Override
    protected void onStart() {
        super.onStart();
        d("< -------------------- onStart() -------------------- >");
    }

    @Override
    protected void onResume() {
        super.onResume();
        d("< -------------------- onResume() -------------------- >");
    }

    @Override
    protected void onPause() {
        super.onPause();
        d("< -------------------- onPause() -------------------- >");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("< -------------------- onStop() -------------------- >");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d("< -------------------- onDestroy() -------------------- >");
    }

    /**
     * Show a Toast message from the given String resource ID.
     */
    protected void toast(int stringResId) {
        final String message = getText(stringResId).toString();
        toast(message);
    }

    /**
     * Show a Toast message from the given String resource ID, for the given amount of duration.
     */
    protected void toast(int stringResId, int duration) {
        final String message = getText(stringResId).toString();
        toast(message, duration);
    }

    /**
     * Show a Toast from the given String message, using a default duration of short.
     */
    protected void toast(String message) {
        toast(message, Toast.LENGTH_SHORT);
    }

    /**
     * Show a Toast from the given String message, using the provided duration.
     */
    protected void toast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }

    /**
     * Log the provided message out to the debug level.
     */
    protected void d(String message) {
        Util.d(this, message);
    }

    /**
     * Log the provided message out to the error level.
     */
    protected void e(String message) {
        Util.e(this, message);
    }
}
