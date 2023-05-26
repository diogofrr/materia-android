package devandroid.diogoferreira.agendadecompromissos;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import devandroid.diogoferreira.agendadecompromissos.model.Compromisso;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Compromisso> compromissos = new ArrayList<>();

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

        closeBtn.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Itens salvos com sucesso!", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void clearFields(){
        titleInput.setText("");
        descriptionInput.setText("");
        localeInput.setText("");
        dateInput.setText("");
        hourInput.setText("");
    }

    private void saveTask() {
        String titleInputcString = titleInput.getText().toString();
        String descriptionInputString = descriptionInput.getText().toString();
        String localeInputString = localeInput.getText().toString();
        String dateInputString = dateInput.getText().toString();
        String hourInputString = hourInput.getText().toString();

        Item novoItem;

        if (itemInputString.equals("") || (qtdInputString.equals("") || qtdInputString.equals("0")) || shopInputString.equals("")) {
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novoItem = new Item(itemInputString, qtdInputString, shopInputString);
            itens.add(novoItem);
            clearFields();
            Toast.makeText(MainActivity.this, "Item adicionado com sucesso!", Toast.LENGTH_LONG).show();

            qtdTotalItens.setText((String.format("(%d)", itens.size())));
        }
    }
}