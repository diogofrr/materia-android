package devandroid.diogoferreira.applistacurso.controller;
import java.util.ArrayList;
import java.util.List;

import devandroid.diogoferreira.applistacurso.model.Curso;

public class CursoController {
    private List listaCursos;

    public List getListaCursos() {
        listaCursos = new ArrayList<Curso>();
        listaCursos.add(new Curso("Medicina"));
        listaCursos.add(new Curso("TDS"));
        listaCursos.add(new Curso("Jogo do bixo"));
        listaCursos.add(new Curso("Galo de Briga Senai"));
        listaCursos.add(new Curso("Nails Designer"));
        listaCursos.add(new Curso("Curso de Agiota"));
        listaCursos.add(new Curso("Catira"));
        listaCursos.add(new Curso("Hacker"));
        return listaCursos;
    }
}