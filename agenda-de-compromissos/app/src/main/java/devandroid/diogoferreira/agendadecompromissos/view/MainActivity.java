package devandroid.diogoferreira.agendadecompromissos.view;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import devandroid.diogoferreira.agendadecompromissos.R;
import devandroid.diogoferreira.agendadecompromissos.model.Compromisso;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Compromisso> compromissos = new ArrayList<>();

    EditText titleInput;
    EditText descriptionInput;
    EditText localeInput;
    EditText dateInput;
    EditText hourInput;

    ImageButton closeBtn;
    Button clearBtn;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleInput = findViewById(R.id.titleInput);
        descriptionInput = findViewById(R.id.descriptionInput);
        localeInput = findViewById(R.id.localeInput);
        dateInput = findViewById(R.id.dateInput);
        hourInput = findViewById(R.id.hourInput);

        closeBtn = findViewById(R.id.closeBtn);
        clearBtn = findViewById(R.id.clearBtn);
        saveBtn = findViewById(R.id.saveBtn);

        closeBtn.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Compromissos salvos com sucesso!", Toast.LENGTH_LONG).show();
            finish();
        });

        saveBtn.setOnClickListener(view -> saveTask());

        clearBtn.setOnClickListener(view -> clearFields());
    }

    private void clearFields(){
        titleInput.setText("");
        descriptionInput.setText("");
        localeInput.setText("");
        dateInput.setText("");
        hourInput.setText("");
    }

    private void saveTask() {
        String titleInputString = titleInput.getText().toString();
        String descriptionInputString = descriptionInput.getText().toString();
        String localeInputString = localeInput.getText().toString();
        String dateInputString = dateInput.getText().toString();
        String hourInputString = hourInput.getText().toString();

        String frase;

        Compromisso novoCompromisso;

        if (titleInputString.equals("") || descriptionInputString.equals("") || localeInputString.equals("") || dateInputString.equals("") || hourInputString.equals("")) {
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novoCompromisso = new Compromisso(titleInputString, descriptionInputString, localeInputString, dateInputString, hourInputString);
            compromissos.add(novoCompromisso);
            clearFields();

            if(compromissos.size() != 0){
                frase = "Compromisso adicionado com sucesso!";
            } else {
                frase = "Até logo :)";
            }
            Toast.makeText(MainActivity.this, frase, Toast.LENGTH_LONG).show();
        }
    }
}