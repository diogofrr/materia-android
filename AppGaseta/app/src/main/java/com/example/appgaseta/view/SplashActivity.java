package com.example.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.appgaseta.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        contarTelaSplash();
    }

    private void contarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent TelaPrincipal = new Intent(SplashActivity.this, MainActivityAppGaseta.class);
                startActivity(TelaPrincipal);
                finish();
            }
        },TIME_OUT_SPLASH);
    }
}