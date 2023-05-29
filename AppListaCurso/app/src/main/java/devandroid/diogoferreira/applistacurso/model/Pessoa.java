package devandroid.diogoferreira.applistacurso.model;

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

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getNomeCursoDesejado() {
        return nomeCursoDesejado;
    }

    public void setNomeCursoDesejado(String nomeCursoDesejado) {
        this.nomeCursoDesejado = nomeCursoDesejado;
    }

    public String getTelefoneDeContato() {
        return telefoneDeContato;
    }

    public void setTelefoneDeContato(String telefoneDeContato) {
        this.telefoneDeContato = telefoneDeContato;
    }
}
