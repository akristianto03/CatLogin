package com.example.catlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start = new Intent(SplashActivity.this, LoginActivity.class);
                start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(start);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}