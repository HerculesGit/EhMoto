package com.project.herco.ehmoto.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.project.herco.ehmoto.R;

public class SplashScreen extends AppCompatActivity implements Runnable {
    private final static int DELAY = 2000; //2000

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Handler h = new Handler();
        h.postDelayed(this, DELAY);
    }
    @Override
    public void run() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
