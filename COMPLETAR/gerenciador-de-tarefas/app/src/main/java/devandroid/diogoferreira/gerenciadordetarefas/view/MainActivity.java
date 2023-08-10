package devandroid.diogoferreira.gerenciadordetarefas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import devandroid.diogoferreira.gerenciadordetarefas.R;
import devandroid.diogoferreira.gerenciadordetarefas.controller.TarefaController;
import devandroid.diogoferreira.gerenciadordetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {

    EditText tituloInput;
    EditText descricaoInput;
    EditText dataInput;

    ImageButton saveBtn;
    Button salvarBtn;
    ImageButton voltarTelaPrincipal;
    ImageButton deleteBtn;

    TarefaController tarefaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tarefaController = new TarefaController(MainActivity.this);

        voltarTelaPrincipal = findViewById(R.id.voltarTelaPrincipal);

        tituloInput = findViewById(R.id.tituloInput);
        descricaoInput = findViewById(R.id.descricaoInput);
        dataInput = findViewById(R.id.dataInput);

        deleteBtn = findViewById(R.id.deleteBtn);
        saveBtn = findViewById(R.id.saveBtn);
        salvarBtn = findViewById(R.id.salvarBtn);

        deleteBtn.setOnClickListener(view -> limparCampos());

        voltarTelaPrincipal.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Até logo!", Toast.LENGTH_LONG).show();
            finish();
        });

        saveBtn.setOnClickListener(view -> {
            salvarCampos();
        });

        salvarBtn.setOnClickListener(view -> {
            salvarCampos();
        });
    }

    private void limparCampos(){
        tituloInput.setText("");
        descricaoInput.setText("");
        dataInput.setText("");
    }

    private void salvarCampos(){
        String titulo = tituloInput.getText().toString();
        String descricao = descricaoInput.getText().toString();
        String data = dataInput.getText().toString();

        if (titulo.equals("") || descricao.equals("") || data.equals("")) {
            Toast.makeText(MainActivity.this, "Valores inválidos", Toast.LENGTH_LONG).show();
        } else {
            Tarefa tarefa = new Tarefa(titulo, descricao, data);
            tarefaController.salvarTarefa(tarefa);
            Toast.makeText(MainActivity.this, "Tarefa salva com sucesso!!", Toast.LENGTH_LONG).show();
        }

    }
}