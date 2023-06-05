package devandroid.diogoferreira.listadetarefas.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.listadetarefas.model.Tarefa;
import devandroid.diogoferreira.listadetarefas.view.MainActivity;

public class TarefaController {

    private final ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static final String NOME_PREFERENCES = "pref_listaTarefas";
    SharedPreferences preferences;
    SharedPreferences.Editor listaTarefas;

    public TarefaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaTarefas = preferences.edit();

    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "TarefaController iniciada");

        return super.toString();
    }

    public void limparTarefaAction(){
        listaTarefas.clear();
        listaTarefas.apply();
    }

    public void salvarTarefaAction(Tarefa novaTarefa){
        listaTarefas.putString("nome", novaTarefa.getNomeTarefa());
        listaTarefas.putString("descricao", novaTarefa.getDescricaoTarefa());
        listaTarefas.putString("data", novaTarefa.getData());
        listaTarefas.apply();

        this.tarefas.add(novaTarefa);

        Log.d("MVC_Controller", "Salvo: " + this.getTarefas());
    }

    public Tarefa procurarAction() throws Exception {
        String nome = preferences.getString("nome", "");
        String descricao = preferences.getString("descricao", "");
        String data = preferences.getString("data", "");

        if (nome.equals("") || descricao.equals("") || data.equals("")) {
            throw new Exception("Não há dados salvos.");
        } else {
            return new Tarefa(nome, descricao, data);
        }
    }
}
