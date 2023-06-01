package devandroid.diogoferreira.applistacurso.model;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import devandroid.diogoferreira.applistacurso.view.MainActivity;

public class Pessoa {
    private String primeiroNome;
    private String segundoNome;
    private String nomeCursoDesejado;
    private String telefoneDeContato;

    ArrayList<Pessoa> pessoas = new ArrayList<>();

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    EditText firstName;
    EditText secondName;
    EditText phone;
    EditText course;

    Button send;
    Button save;
    Button clear;

    public Pessoa(String primeiroNome, String segundoNome, String nomeCursoDesejado, String telefoneDeContato) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.nomeCursoDesejado = nomeCursoDesejado;
        this.telefoneDeContato = telefoneDeContato;
    }

    public void main(MainActivity mainActivity) {

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
