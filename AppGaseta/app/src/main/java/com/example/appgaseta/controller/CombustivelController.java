package com.example.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appgaseta.database.GasEtaDB;
import com.example.appgaseta.model.Combustiveis;
import com.example.appgaseta.view.MainActivityAppGaseta;

public class CombustivelController extends GasEtaDB {
    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(MainActivityAppGaseta mainActivityAppGaseta) {
        super(mainActivityAppGaseta);
        preferences = mainActivityAppGaseta.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "PessoaController iniciada");

        return super.toString();
    }

    public double calcularGasEta(Combustiveis combustiveis) {
        double precogasolina = combustiveis.getGasolina();
        double precoetanol = combustiveis.getEtanol();

        return (precoetanol / precogasolina);
    }

    public Combustiveis salvar(Combustiveis combustiveis) {
        Log.d("MVC_Controller","Salvo"+combustiveis.toString());

        ContentValues dados = new ContentValues();

        listaVip.putFloat("precoGasolina", combustiveis.getGasolina());
        listaVip.putFloat("precoEtanol", combustiveis.getEtanol());
        listaVip.putString("resultado", calculargaseta(combustiveis.getGasolina(), combustiveis.getEtanol()));
        listaVip.apply();

        dados.put("nomeCombustivel", "Gasolina");
        dados.put("precoCombustivel", combustiveis.getGasolina());
        dados.put("resultado", combustiveis.getResutado());

        salvarObjeto("combustivel", dados);

        dados.put("nomeCombustivel", "Etanol");
        dados.put("precoCombustivel", combustiveis.getEtanol());
        dados.put("resultado", combustiveis.getResutado());

        salvarObjeto("combustivel", dados);

        return combustiveis;
    }

    public Combustiveis buscar(Combustiveis combustiveis){
        float gas = combustiveis.setGasolina(preferences.getFloat("precoGasolina", 0.0F));
        float eta = combustiveis.setEtanol(preferences.getFloat("precoEtanol", 0.0F));

        return combustiveis;
    }

    public void limpar(){

        listaVip.clear();
        listaVip.apply();
    }

    public String calculargaseta(float precogasolina, float precoetanol){

        float res;
        String resultado;

        res = precoetanol / precogasolina;

        if (res <= 0.7){
            resultado = "Etanol";
        }else {
            resultado = "Gasolina";
        }

        return resultado;
    }
}
