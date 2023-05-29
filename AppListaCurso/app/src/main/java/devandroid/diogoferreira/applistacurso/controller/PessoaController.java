package devandroid.diogoferreira.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.applistacurso.model.Pessoa;

public class PessoaController {

    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public PessoaController() {
    }

    public void savePersonAction(Pessoa newPerson){
        this.pessoas.add(newPerson);
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "PessoaController iniciada");

        return super.toString();
    }
}
