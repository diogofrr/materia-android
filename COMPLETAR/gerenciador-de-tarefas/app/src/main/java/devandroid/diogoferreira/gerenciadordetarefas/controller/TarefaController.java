package devandroid.diogoferreira.gerenciadordetarefas.controller;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import devandroid.diogoferreira.gerenciadordetarefas.database.TarefaDB;
import devandroid.diogoferreira.gerenciadordetarefas.model.Tarefa;
import devandroid.diogoferreira.gerenciadordetarefas.view.MainActivity;

public class TarefaController extends TarefaDB {

    public TarefaController(MainActivity mainActivity) {
        super(mainActivity);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void salvarTarefa(Tarefa tarefa) {
        ContentValues dados = new ContentValues();

        dados.put("titulo", tarefa.getTitulo());
        dados.put("descricao", tarefa.getDescricao());
        dados.put("data", tarefa.getData());

        salvarObjeto("tarefas", dados);
    }
}
