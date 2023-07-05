package com.example.appgaseta.controller;

import com.example.appgaseta.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listaCursos;

    public List getListaCursos() {
        listaCursos = new ArrayList<Curso>();

        listaCursos.add(new Curso("Python The Best 😎"));
        listaCursos.add(new Curso("TDS"));
        listaCursos.add(new Curso("Jogo do bixo"));
        listaCursos.add(new Curso("Galo de Briga Senai"));
        listaCursos.add(new Curso("Nails Designer"));
        listaCursos.add(new Curso("Curso de Agiota"));
        listaCursos.add(new Curso("Catira"));
        listaCursos.add(new Curso("Java 🤮"));
        return listaCursos;
    }
    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size();i++){
            Curso objeto = (Curso) getListaCursos().get(i);

            dados.add(objeto.getCursoDesejado());
        }
        return dados;
    }
    /*private List<String> cursos = new ArrayList<>(Arrays.asList("TDS", "Enfermagem", "Medicina", "Direito", "Biologia", "Enfermagem", "Nail Designer", "Cabeleleiro"));
    public List<String> getCursos (){ return cursos;}
    public void setCursos(List<String> cursos) { this.cursos = cursos;}*/
}


