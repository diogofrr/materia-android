package devandroid.diogoferreira.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import devandroid.diogoferreira.listadecompras.controller.ItemController;
import devandroid.diogoferreira.listadecompras.model.Item;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_itens";

    ItemController controller;

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

        SharedPreferences.Editor listaItens = preferences.edit();

        controller = new ItemController();

        qtdTotalItens = findViewById(R.id.qtdTotalItens);

        itemInput = findViewById(R.id.itemInput);
        qtdInput = findViewById(R.id.qtdInput);
        shopInput = findViewById(R.id.shopInput);

        closeApp = findViewById(R.id.closeApp);
        clearBtn = findViewById(R.id.clearBtn);
        saveBtn = findViewById(R.id.saveBtn);

        clearBtn.setOnClickListener(view -> clearFields(listaItens));
        saveBtn.setOnClickListener(view -> saveTask(listaItens));
        closeApp.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Itens salvos com sucesso!", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void clearFields(SharedPreferences.Editor listaItensProp){
        itemInput.setText("");
        qtdInput.setText("");
        shopInput.setText("");

        listaItensProp.clear();
    }

    @SuppressLint("DefaultLocale")
    private void saveTask(SharedPreferences.Editor listaItensProp) {
        String itemInputString = itemInput.getText().toString();
        String qtdInputString = qtdInput.getText().toString();
        String shopInputString = shopInput.getText().toString();
        Item novoItem;

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);

        if (itemInputString.equals("") || (qtdInputString.equals("") || qtdInputString.equals("0")) || shopInputString.equals("")) {
            Toast.makeText(MainActivity.this, "Verifique os campos e tente novamente.", Toast.LENGTH_LONG).show();
        } else {
            novoItem = new Item(itemInputString, qtdInputString, shopInputString);
            controller.saveItemAction(novoItem);
            Toast.makeText(MainActivity.this, "Item adicionado com sucesso!", Toast.LENGTH_LONG).show();

            listaItensProp.putString("item", itemInputString);
            listaItensProp.putString("qtd", qtdInputString);
            listaItensProp.putString("shop", shopInputString);
            listaItensProp.apply();

            clearFields(listaItensProp);

            qtdTotalItens.setText((String.format("(%d)", controller.getItens().size())));
        }
    }
}


