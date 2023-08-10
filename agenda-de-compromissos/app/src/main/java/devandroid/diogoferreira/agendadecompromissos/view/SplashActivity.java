package devandroid.diogoferreira.agendadecompromissos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.diogoferreira.agendadecompromissos.database.AgendaDB;
import devandroid.diogoferreira.agendadecompromissos.R;
import devandroid.diogoferreira.agendadecompromissos.database.AgendaDB;

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

            AgendaDB db = new AgendaDB(SplashActivity.this);

            Intent TelaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(TelaPrincipal);
            finish();
        },TIME_OUT_SPLASH);
    }

}