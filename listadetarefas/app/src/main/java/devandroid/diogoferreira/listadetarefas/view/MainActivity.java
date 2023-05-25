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
import devandroid.diogoferreira.listadetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<Tarefa> tarefas = new ArrayList<>();

    EditText tarefaInput;
    EditText descricaoInput;
    EditText dateInput;

    Button salvar;
    Button limpar;
    ImageButton encerrarApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tarefaInput = findViewById(R.id.tarefaInput);
        descricaoInput = findViewById(R.id.descricaoInput);
        dateInput = findViewById(R.id.dateInput);

        salvar = findViewById(R.id.salvar);
        limpar = findViewById(R.id.limpar);
        encerrarApp = findViewById(R.id.encerrarApp);

        limpar.setOnClickListener(view -> clearFields());
        salvar.setOnClickListener(view -> saveTask());
        encerrarApp.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Até logo!", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void clearFields(){
        tarefaInput.setText("");
        descricaoInput.setText("");
        dateInput.setText("");
    }

    private void saveTask(){
        String tarefaInputString = tarefaInput.getText().toString();
        String descricaoInputString = descricaoInput.getText().toString();
        String dateInputString = dateInput.getText().toString();
        Tarefa novaTarefa;

        if(tarefaInputString.equals("") || descricaoInputString.equals("") || dateInputString.equals("")){
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novaTarefa = new Tarefa(tarefaInputString, descricaoInputString, dateInputString);
            tarefas.add(novaTarefa);
            clearFields();
            Toast.makeText(MainActivity.this, "Usuário salvo com sucesso!", Toast.LENGTH_LONG).show();
        }

        Log.i("POOAndroid", "Total: " + tarefas.size());
    }
}

