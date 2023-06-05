package devandroid.diogoferreira.listadetarefas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import devandroid.diogoferreira.listadetarefas.R;
import devandroid.diogoferreira.listadetarefas.controller.TarefaController;
import devandroid.diogoferreira.listadetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {
    TarefaController controller;

    EditText tarefaInput;
    EditText descricaoInput;
    EditText dateInput;

    Button salvarBtn;
    Button limparBtn;
    Button pesquisarBtn;
    ImageButton encerrarApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new TarefaController(MainActivity.this);

        tarefaInput = findViewById(R.id.tarefaInput);
        descricaoInput = findViewById(R.id.descricaoInput);
        dateInput = findViewById(R.id.dateInput);

        salvarBtn = findViewById(R.id.salvarBtn);
        limparBtn = findViewById(R.id.limparBtn);
        pesquisarBtn = findViewById(R.id.pesquisarBtn);
        encerrarApp = findViewById(R.id.encerrarApp);

        limparBtn.setOnClickListener(view -> deletarTarefa());
        salvarBtn.setOnClickListener(view -> salvarTarefas());
        encerrarApp.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Até logo!", Toast.LENGTH_LONG).show();
            finish();
        });
        pesquisarBtn.setOnClickListener(view -> procurar());
    }

    private void limparCampos(){
        tarefaInput.setText("");
        descricaoInput.setText("");
        dateInput.setText("");
    }

    private void deletarTarefa(){
        limparCampos();
        controller.limparTarefaAction();

        Toast.makeText(MainActivity.this, "Tarefa deletada com sucesso!", Toast.LENGTH_LONG).show();
    }

    private void salvarTarefas(){
        String tarefaInputString = tarefaInput.getText().toString();
        String descricaoInputString = descricaoInput.getText().toString();
        String dateInputString = dateInput.getText().toString();
        Tarefa novaTarefa;

        if(tarefaInputString.equals("") || descricaoInputString.equals("") || dateInputString.equals("")){
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novaTarefa = new Tarefa(tarefaInputString, descricaoInputString, dateInputString);
            controller.salvarTarefaAction(novaTarefa);

            limparCampos();

            Toast.makeText(MainActivity.this, "Tarefa salva com sucesso!", Toast.LENGTH_LONG).show();
        }

        Log.i("POOAndroid", "Total: " + controller.getTarefas().size());
    }

    public void procurar() {
        try {
            Tarefa tarefa = controller.procurarAction();

            tarefaInput.setText(tarefa.getNomeTarefa());
            descricaoInput.setText(tarefa.getDescricaoTarefa());
            dateInput.setText(tarefa.getData());

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}

