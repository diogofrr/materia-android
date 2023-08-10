package devandroid.diogoferreira.gerenciadordetarefas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.diogoferreira.gerenciadordetarefas.R;
import devandroid.diogoferreira.gerenciadordetarefas.database.TarefaDB;

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

            TarefaDB db = new TarefaDB(SplashActivity.this);

            Intent TelaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(TelaPrincipal);
            finish();
        },TIME_OUT_SPLASH);
    }

}