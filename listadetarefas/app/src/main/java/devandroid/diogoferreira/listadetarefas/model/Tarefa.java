package devandroid.diogoferreira.listadetarefas.model;

public class Tarefa {
    private String nomeTarefa;
    private String descricaoTarefa;
    private String data;

    public Tarefa(String nomeTarefa, String descricaoTarefa, String data) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.data = data;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nomeTarefa='" + nomeTarefa + '\'' +
                ", descricaoTarefa='" + descricaoTarefa + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
