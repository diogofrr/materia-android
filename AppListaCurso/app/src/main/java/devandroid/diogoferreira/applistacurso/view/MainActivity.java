package devandroid.diogoferreira.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import devandroid.diogoferreira.applistacurso.R;
import devandroid.diogoferreira.applistacurso.controller.PessoaController;
import devandroid.diogoferreira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    PessoaController controller;

    EditText firstName;
    EditText secondName;
    EditText phone;
    EditText course;

    Button send;
    Button save;
    Button clear;

    ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);

        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        phone = findViewById(R.id.phone);
        course = findViewById(R.id.course);
        searchButton = findViewById(R.id.searchButton);

        send = findViewById(R.id.send);
        save = findViewById(R.id.save);
        clear = findViewById(R.id.clear);

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
            Pessoa pessoa = controller.findAction();

            String primeiroNomeData = pessoa.getPrimeiroNome();
            String segundoNomeData = pessoa.getSegundoNome();
            String phoneData = pessoa.getTelefoneDeContato();
            String courseData = pessoa.getNomeCursoDesejado();

            firstName.setText(primeiroNomeData);
            secondName.setText(segundoNomeData);
            phone.setText(phoneData);
            course.setText(courseData);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void clearFields() {

        firstName.setText("");
        secondName.setText("");
        phone.setText("");
        course.setText("");

        Toast.makeText(MainActivity.this, "Dados limpos com sucesso!", Toast.LENGTH_LONG).show();

        controller.clearAction();
    }

    private void savePerson() {
        String firstNameInput = firstName.getText().toString();
        String secondNameInput = secondName.getText().toString();
        String phoneInput = phone.getText().toString();
        String courseInput = course.getText().toString();

        Pessoa novaPessoa;

        if (firstNameInput.equals("") || secondNameInput.equals("") || phoneInput.equals("") || courseInput.equals("")) {
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novaPessoa = new Pessoa(firstNameInput, secondNameInput, phoneInput, courseInput);

            pessoas.add(novaPessoa);

            controller.saveAction(novaPessoa);

            firstName.setText("");
            secondName.setText("");
            phone.setText("");
            course.setText("");

            Toast.makeText(MainActivity.this, "Usuário salvo com sucesso!", Toast.LENGTH_LONG).show();
        }

        Log.i("POOAndroid", "Total: " + pessoas.size());
    }
}