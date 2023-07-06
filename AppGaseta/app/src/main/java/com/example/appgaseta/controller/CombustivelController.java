package com.example.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appgaseta.model.Combustiveis;
import com.example.appgaseta.view.MainActivityAppGaseta;

public class CombustivelController {
    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(MainActivityAppGaseta mainActivityAppGaseta) {
        preferences = mainActivityAppGaseta.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public CombustivelController() {
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

        listaVip.putFloat("precoGasolina", combustiveis.getGasolina());
        listaVip.putFloat("precoEtanol", combustiveis.getEtanol());
        listaVip.putString("resultado", Calculargaseta.calculargaseta(combustiveis.getGasolina(), combustiveis.getEtanol()));
        listaVip.apply();
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
}
