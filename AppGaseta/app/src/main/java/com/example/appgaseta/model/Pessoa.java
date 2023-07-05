package com.example.appgaseta.model;

public class Pessoa {

    private String nome;
    private String sobreNome;
    private String nomeCurso;
    private String telefone;

    public Pessoa(){

    }

    public Pessoa(String nome, String sobreNome, String nomeCurso, String telefone) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nomeCurso = nomeCurso;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
