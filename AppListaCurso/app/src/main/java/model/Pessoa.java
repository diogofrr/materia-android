package model;

public class Pessoa {
    private String primeiroNome;
    private String segundoNome;
    private String nomeCursoDesejado;
    private String telefoneDeContato;

    public Pessoa(String primeiroNome, String segundoNome, String nomeCursoDesejado, String telefoneDeContato) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.nomeCursoDesejado = nomeCursoDesejado;
        this.telefoneDeContato = telefoneDeContato;
    }

    private String getPrimeiroNome() {
        return primeiroNome;
    }

    private String getSegundoNome() {
        return segundoNome;
    }

    private String getNomeCursoDesejado() {
        return nomeCursoDesejado;
    }

    private String getTelefoneDeContato() {
        return telefoneDeContato;
    }

    private void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    private void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    private void setNomeCursoDesejado(String nomeCursoDesejado) {
        this.nomeCursoDesejado = nomeCursoDesejado;
    }

    private void setTelefoneDeContato(String telefoneDeContato) {
        this.telefoneDeContato = telefoneDeContato;
    }
}
