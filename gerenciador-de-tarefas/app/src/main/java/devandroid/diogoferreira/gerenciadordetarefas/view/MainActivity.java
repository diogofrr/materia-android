package devandroid.diogoferreira.gerenciadordetarefas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import devandroid.diogoferreira.gerenciadordetarefas.R;

public class MainActivity extends AppCompatActivity {

    EditText tituloInput;
    EditText descricaoInput;
    EditText dataInput;

    ImageButton saveBtn;
    ImageButton voltarTelaPrincipal;
    ImageButton deleteBtn;
    ImageButton searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voltarTelaPrincipal = findViewById(R.id.voltarTelaPrincipal);
        deleteBtn = findViewById(R.id.deleteBtn);
        searchBtn = findViewById(R.id.searchBtn);
        saveBtn = findViewById(R.id.saveBtn);

        deleteBtn.setOnClickListener(view -> limparCampos());
        voltarTelaPrincipal.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Até logo!", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void limparCampos(){
        tituloInput.setText("");
        descricaoInput.setText("");
        dataInput.setText("");
    }

    private void salvarCampos(){
    }
}