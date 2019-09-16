package com.example.as_pointer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent homeActivity = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(homeActivity);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
