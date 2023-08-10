package devandroid.diogoferreira.imc.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.diogoferreira.imc.database.ImcDB;
import devandroid.diogoferreira.imc.model.Pessoa;
import devandroid.diogoferreira.imc.view.MainActivity;

public class PessoaController extends ImcDB {

    public static final String NOME_PREFERENCES = "pref_IMC";
    SharedPreferences preferences;
    SharedPreferences.Editor listaIMC;

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaIMC = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "PessoaController iniciada");

        return super.toString();
    }

    public double calcularIMC(Pessoa pessoa) {
        double altura = pessoa.getAltura();
        double peso = pessoa.getPeso();

        double imc = (peso / (altura * altura));
        listaIMC.putString("IMC", String.valueOf(imc));
        listaIMC.apply();

        Log.d("MVC_Controller", "Salvo: " + imc);

        ContentValues dados = new ContentValues();

        dados.put("altura", altura);
        dados.put("peso", peso);
        dados.put("resultado", imc);

        salvarObjeto("imc", dados);

        return imc;
    }

}
