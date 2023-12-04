package com.example.myapplication.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

// SplashActivity.java
public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Optional: Add a delay before transitioning to the main activity
        int splashDuration = 12000; // milliseconds
        new Handler().postDelayed(() -> {
            // Start your main activity
            startActivity(new Intent(SplashScreen.this,LoginPage.class));
            finish();
        }, splashDuration);
    }
}
