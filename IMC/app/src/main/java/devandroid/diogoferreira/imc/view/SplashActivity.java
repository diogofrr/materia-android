package devandroid.diogoferreira.imc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.diogoferreira.imc.R;
import devandroid.diogoferreira.imc.database.ImcDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        contarTelaSplash();
    }

    private void contarTelaSplash() {
        new Handler().postDelayed(() -> {

            ImcDB db = new ImcDB(SplashActivity.this);

            Intent TelaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(TelaPrincipal);
            finish();
        },TIME_OUT_SPLASH);
    }

}