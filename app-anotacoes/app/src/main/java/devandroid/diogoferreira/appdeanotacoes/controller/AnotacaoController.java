package devandroid.diogoferreira.appdeanotacoes.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.diogoferreira.appdeanotacoes.model.Anotacao;
import devandroid.diogoferreira.appdeanotacoes.view.MainActivity;

public class AnotacaoController {

    public static final String NOME_PREFERENCES = "pref_listaAnotacoes";
    SharedPreferences preferences;
    SharedPreferences.Editor listaAnotacoes;

    public AnotacaoController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaAnotacoes = preferences.edit();

    }

    public void limparAnotacoesAction(){
        listaAnotacoes.clear();
        listaAnotacoes.apply();
    }

    public void salvarAnotacoesAction(Anotacao novaAnotacao){
        listaAnotacoes.putString("titulo", novaAnotacao.getTitulo());
        listaAnotacoes.putString("descricao", novaAnotacao.getDescricao());
        listaAnotacoes.putString("data", novaAnotacao.getData());
        listaAnotacoes.apply();

        Log.d("MVC_Controller", "Salvo: " + novaAnotacao.toString());
    }

    public Anotacao procurarAnotacoesAction() throws Exception {
        String titulo = preferences.getString("titulo", "");
        String descricao = preferences.getString("descricao", "");
        String data = preferences.getString("data", "");

        if (titulo.equals("") || descricao.equals("") || data.equals("")) {
            throw new Exception("Não há dados salvos.");
        } else {
            return new Anotacao(titulo, descricao, data);
        }
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "AnotacaoController iniciada");

        return super.toString();
    }
}
