package devandroid.diogoferreira.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import devandroid.diogoferreira.listadecompras.model.Item;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Item> itens = new ArrayList<>();

    TextView qtdTotalItens;

    EditText itemInput;
    EditText qtdInput;
    EditText shopInput;

    ImageButton closeApp;
    Button clearBtn;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qtdTotalItens = findViewById(R.id.qtdTotalItens);

        itemInput = findViewById(R.id.itemInput);
        qtdInput = findViewById(R.id.qtdInput);
        shopInput = findViewById(R.id.shopInput);

        closeApp = findViewById(R.id.closeApp);
        clearBtn = findViewById(R.id.clearBtn);
        saveBtn = findViewById(R.id.saveBtn);

        clearBtn.setOnClickListener(view -> clearFields());
        saveBtn.setOnClickListener(view -> saveTask());
        closeApp.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Itens salvos com sucesso!", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void clearFields(){
        itemInput.setText("");
        qtdInput.setText("");
        shopInput.setText("");
    }

    @SuppressLint("DefaultLocale")
    private void saveTask() {
        String itemInputString = itemInput.getText().toString();
        String qtdInputString = qtdInput.getText().toString();
        String shopInputString = shopInput.getText().toString();
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


