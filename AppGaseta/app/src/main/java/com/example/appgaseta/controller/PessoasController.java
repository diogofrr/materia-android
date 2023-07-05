package com.example.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appgaseta.R;
import com.example.appgaseta.model.Pessoa;
import com.example.appgaseta.view.MainActivity;

public class PessoasController {

    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoasController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado...");

        return super.toString();
    }


    public Pessoa salvar(Pessoa outraPessoa) {
        Log.d("MVC_Controller","Salvo"+outraPessoa.toString());

        listaVip.putString("precoGasolina", outraPessoa.getNome());
        listaVip.putString("precoEtanol", outraPessoa.getSobreNome());
        listaVip.apply();
        return outraPessoa;
    }

    public Pessoa buscar(Pessoa outraPessoa){
        outraPessoa.setNome(preferences.getString("precoGasolina", "R$0,00"));
        outraPessoa.setSobreNome(preferences.getString("sobreNome", "R$0,00"));
        return outraPessoa;
    }

    public void limpar(){

        listaVip.clear();
        listaVip.apply();
    }

}
