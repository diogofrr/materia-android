package devandroid.diogoferreira.appdeanotacoes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import devandroid.diogoferreira.appdeanotacoes.R;
import devandroid.diogoferreira.appdeanotacoes.controller.AnotacaoController;
import devandroid.diogoferreira.appdeanotacoes.model.Anotacao;

public class MainActivity extends AppCompatActivity {

    AnotacaoController controller;

    EditText titleInput;
    EditText descriptionInput;
    EditText dateInput;

    ImageButton closeBtn;
    ImageButton searchBtn;
    ImageButton deleteBtn;
    ImageButton saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new AnotacaoController(MainActivity.this);

        titleInput = findViewById(R.id.titleInput);
        descriptionInput = findViewById(R.id.descriptionInput);
        dateInput = findViewById(R.id.dateInput);

        closeBtn = findViewById(R.id.closeBtn);
        searchBtn = findViewById(R.id.searchBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        saveBtn = findViewById(R.id.saveBtn);

        closeBtn.setOnClickListener(view -> {
            finish();
        });
        searchBtn.setOnClickListener(view -> procurarAnotacao());
        deleteBtn.setOnClickListener(view -> deletarAnotacao());
        saveBtn.setOnClickListener(view -> salvarAnotacao());
    }

    private void limparCampos(){
        titleInput.setText("");
        descriptionInput.setText("");
        dateInput.setText("");
    }

    private void deletarAnotacao(){
        limparCampos();
        controller.limparAnotacoesAction();

        Toast.makeText(MainActivity.this, "Anotação deletada com sucesso!", Toast.LENGTH_LONG).show();
    }

    private void salvarAnotacao(){
        String titleInputString = titleInput.getText().toString();
        String descriptionInputString = descriptionInput.getText().toString();
        String dateInputString = dateInput.getText().toString();
        Anotacao notaAnotacao;

        if(titleInputString.equals("") || descriptionInputString.equals("") || dateInputString.equals("")){
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            notaAnotacao = new Anotacao(titleInputString, descriptionInputString, dateInputString);
            controller.salvarAnotacoesAction(notaAnotacao);

            limparCampos();

            Toast.makeText(MainActivity.this, "Anotação salva com sucesso!", Toast.LENGTH_LONG).show();
        }
    }

    private void procurarAnotacao(){
        try {
            Anotacao anotacao = controller.procurarAnotacoesAction();

            titleInput.setText(anotacao.getTitulo());
            descriptionInput.setText(anotacao.getDescricao());
            dateInput.setText(anotacao.getData());

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}