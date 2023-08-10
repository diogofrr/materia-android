package devandroid.diogoferreira.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import devandroid.diogoferreira.applistacurso.R;
import devandroid.diogoferreira.applistacurso.controller.CursoController;
import devandroid.diogoferreira.applistacurso.controller.PessoaController;
import devandroid.diogoferreira.applistacurso.model.Curso;
import devandroid.diogoferreira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    PessoaController pessoaController;
    CursoController cursoController;
    List<Curso> listaCurso;

    EditText firstName;
    EditText secondName;
    EditText phone;
    Spinner courseSpn;

    Button send;
    Button save;
    Button clear;

    ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoaController = new PessoaController(MainActivity.this);

        cursoController = new CursoController();
        listaCurso = cursoController.getListaCursos();

        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        phone = findViewById(R.id.phone);
        courseSpn = findViewById(R.id.course);
        searchButton = findViewById(R.id.searchButton);

        send = findViewById(R.id.send);
        save = findViewById(R.id.save);
        clear = findViewById(R.id.clear);

        courseSpn.setAdapter(new ArrayAdapter<Curso>(this, android.R.layout.simple_list_item_1, listaCurso));

        clear.setOnClickListener(view -> clearFields());

        send.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Lista finalizada", Toast.LENGTH_LONG).show();
            finish();
        });

        save.setOnClickListener(view -> savePerson());

        searchButton.setOnClickListener(view -> findPerson());
    }

    private void findPerson() {
        try {
            Pessoa pessoa = pessoaController.findAction();

            String primeiroNomeData = pessoa.getPrimeiroNome();
            String segundoNomeData = pessoa.getSegundoNome();
            String phoneData = pessoa.getTelefoneDeContato();

            firstName.setText(primeiroNomeData);
            secondName.setText(segundoNomeData);
            phone.setText(phoneData);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void clearFields() {

        firstName.setText("");
        secondName.setText("");
        phone.setText("");

        Toast.makeText(MainActivity.this, "Dados limpos com sucesso!", Toast.LENGTH_LONG).show();

        pessoaController.clearAction();
    }

    private void savePerson() {
        String firstNameInput = firstName.getText().toString();
        String secondNameInput = secondName.getText().toString();
        String phoneInput = phone.getText().toString();
        String course = courseSpn.getSelectedItem().toString();

        Pessoa novaPessoa;

        if (firstNameInput.equals("") || secondNameInput.equals("") || phoneInput.equals("")) {
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novaPessoa = new Pessoa(firstNameInput, secondNameInput, phoneInput, course);

            pessoas.add(novaPessoa);

            pessoaController.saveAction(novaPessoa);

            firstName.setText("");
            secondName.setText("");
            phone.setText("");

            Toast.makeText(MainActivity.this, "Usuário salvo com sucesso!", Toast.LENGTH_LONG).show();
        }

        Log.i("POOAndroid", "Total: " + pessoas.size());
    }
}