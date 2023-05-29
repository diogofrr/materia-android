package devandroid.diogoferreira.agendadecompromissos.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.agendadecompromissos.model.Compromisso;

public class CompromissoController {
    private final ArrayList<Compromisso> compromissos = new ArrayList<>();

    public CompromissoController() {
    }

    public ArrayList<Compromisso> getCompromissos() {
        return compromissos;
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "CompromissoController iniciada");

        return super.toString();
    }

    public void saveCompromissoAction(Compromisso novoCompromisso){
        compromissos.add(novoCompromisso);

        Log.d("MVC_Controller", "Compromisso salvo: " + this.getCompromissos());
    }
}
