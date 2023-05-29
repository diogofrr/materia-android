package devandroid.diogoferreira.listadetarefas.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.listadetarefas.model.Tarefa;

public class TarefaController {

    private final ArrayList<Tarefa> tarefas = new ArrayList<>();

    public TarefaController() {
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

    public void saveTarefaAction(Tarefa tarefa){
        this.tarefas.add(tarefa);

        Log.d("MVC_Controller", "Salvo: " + this.getTarefas());
    }
}
