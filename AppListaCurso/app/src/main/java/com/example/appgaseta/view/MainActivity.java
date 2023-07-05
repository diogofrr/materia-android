package com.example.appgaseta.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgaseta.R;
import com.example.appgaseta.controller.CursoController;
import com.example.appgaseta.controller.PessoasController;
import com.example.appgaseta.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoasController controller;
    CursoController cursoController;
    Pessoa pessoa;
    Pessoa outraPessoa;


    List<String> nomesDoCursos;
    EditText editPrimeiroNome;
    EditText editSegundoNome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button bpnLimpar;
    Button bpnSalvar;
    Button bpnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        CursoController cursoController = new CursoController();

        cursoController = new CursoController();
        nomesDoCursos = cursoController.dadosSpinner();
        cursoController.getListaCursos();

        controller = new PessoasController(MainActivity.this);
        controller.toString();

        outraPessoa = new Pessoa();
        controller.buscar(outraPessoa);

        editPrimeiroNome = findViewById(R.id.Text_edit_valor_gasolina);
        editSegundoNome = findViewById((R.id.Text_edit_valor_etanol));
        editCursoDesejado = findViewById(R.id.text_NomeDoCurso);
        editTelefoneContato = findViewById(R.id.text_TelefoneDeContato);

        editPrimeiroNome.setText(outraPessoa.getNome());
        editSegundoNome.setText(outraPessoa.getSobreNome());
        editTelefoneContato.setText(outraPessoa.getTelefone());
        editCursoDesejado.setText(outraPessoa.getNomeCurso());

        bpnLimpar = findViewById(R.id.button_Limpar);
        bpnFinalizar = findViewById(R.id.button_Finalizar);
        bpnSalvar = findViewById(R.id.button_Salvar);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        bpnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSegundoNome.setText("");
                editCursoDesejado.setText("");
                editTelefoneContato.setText("");
                controller.limpar();
            }
        });
        bpnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Encerrando app...", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        bpnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outraPessoa.setNome(editPrimeiroNome.getText().toString());
                outraPessoa.setSobreNome(editSegundoNome.getText().toString());
                outraPessoa.setNomeCurso(editCursoDesejado.getText().toString());
                outraPessoa.setTelefone(editTelefoneContato.getText().toString());
                controller.salvar(outraPessoa);
            }
        });
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cursoController.getListaCursos()));
        Log.i("POOAndroid", outraPessoa.toString());
    }
}