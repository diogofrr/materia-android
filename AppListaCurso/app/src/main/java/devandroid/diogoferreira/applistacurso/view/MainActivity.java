package devandroid.diogoferreira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import devandroid.diogoferreira.applistacurso.R;

import devandroid.diogoferreira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    EditText firstName;
    EditText secondName;
    EditText phone;
    EditText course;

    Button send;
    Button save;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        phone = findViewById(R.id.phone);
        course = findViewById(R.id.course);

        send = findViewById(R.id.send);
        save = findViewById(R.id.save);
        clear = findViewById(R.id.clear);

        pessoas.add(new Pessoa("Diogo", "Ferreira", "Téc. Desenvolvimento de Sistemas", "31971890386"));
        pessoas.add(new Pessoa("Pedro", "Augusto", "Téc. Desenvolvimento de Sistemas", "34940028922"));

        Log.i("POOAndroid", pessoas.get(0).toString());
        Log.i("POOAndroid", pessoas.get(1).toString());

        firstName.setText(pessoas.get(0).getPrimeiroNome());
        secondName.setText(pessoas.get(0).getSegundoNome());
        phone.setText(pessoas.get(0).getTelefoneDeContato());
        course.setText(pessoas.get(0).getNomeCursoDesejado());
    }

    private void createPerson(){

    }
}