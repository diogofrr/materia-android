package devandroid.diogoferreira.agendadecompromissos.controller;

import android.content.ContentValues;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.agendadecompromissos.database.AgendaDB;
import devandroid.diogoferreira.agendadecompromissos.model.Compromisso;
import devandroid.diogoferreira.agendadecompromissos.view.MainActivity;

public class CompromissoController extends AgendaDB {
    private final ArrayList<Compromisso> compromissos = new ArrayList<>();

    public CompromissoController(MainActivity mainActivity) {
        super(mainActivity);
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

        ContentValues dados = new ContentValues();
        dados.put("title", novoCompromisso.getTitle());
        dados.put("description", novoCompromisso.getDescription());
        dados.put("date", novoCompromisso.getDate());
        dados.put("hour", novoCompromisso.getHour());
        dados.put("locale", novoCompromisso.getLocale());

        salvarObjeto("agenda", dados);

        Log.d("MVC_Controller", "Compromisso salvo: " + this.getCompromissos());
    }
}
