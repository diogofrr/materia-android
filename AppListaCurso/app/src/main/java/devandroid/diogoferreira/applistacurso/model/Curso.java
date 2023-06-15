package devandroid.diogoferreira.applistacurso.model;

public class Curso {

    private String cursoDesejado;

    public Curso(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        return this.cursoDesejado;
    }
}
