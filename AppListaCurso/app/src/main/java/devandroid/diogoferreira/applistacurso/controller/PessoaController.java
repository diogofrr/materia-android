package devandroid.diogoferreira.applistacurso.controller;

import android.content.SharedPreferences;

import devandroid.diogoferreira.applistacurso.model.Pessoa;
import devandroid.diogoferreira.applistacurso.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";
    SharedPreferences.Editor listaVip;


    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void saveAction(Pessoa pessoa) {
        listaVip.putString("firstName", pessoa.getPrimeiroNome());
        listaVip.putString("secondName", pessoa.getSegundoNome());
        listaVip.putString("phone", pessoa.getTelefoneDeContato());
        listaVip.putString("course", pessoa.getNomeCursoDesejado());
        listaVip.apply();
    }

    public void clearAction() {
        listaVip.clear();
        listaVip.apply();
    }

    public Pessoa findAction() throws Exception {
        String firstName = preferences.getString("firstName", "");
        String secondName = preferences.getString("secondName", "");
        String phone = preferences.getString("phone", "");
        String course = preferences.getString("course", "");

        if (firstName.equals("") || secondName.equals("") || phone.equals("") || course.equals("")) {
            throw new Exception("Não há dados salvos.");
        } else {
            return new Pessoa(firstName, secondName, course, phone);
        }
    }
}
