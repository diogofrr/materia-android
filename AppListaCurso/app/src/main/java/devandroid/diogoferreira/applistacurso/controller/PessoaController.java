package devandroid.diogoferreira.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import devandroid.diogoferreira.applistacurso.database.ListaDB;
import devandroid.diogoferreira.applistacurso.model.Pessoa;
import devandroid.diogoferreira.applistacurso.view.MainActivity;

public class PessoaController extends ListaDB {
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";
    SharedPreferences.Editor listaVip;


    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void saveAction(Pessoa pessoa) {
        listaVip.putString("firstName", pessoa.getPrimeiroNome());
        listaVip.putString("secondName", pessoa.getSegundoNome());
        listaVip.putString("phone", pessoa.getTelefoneDeContato());
        listaVip.putString("course", pessoa.getNomeCursoDesejado());
        listaVip.apply();

        ContentValues dados = new ContentValues();

        dados.put("nome", pessoa.getPrimeiroNome());
        dados.put("sobrenome", pessoa.getSegundoNome());
        dados.put("telefone", pessoa.getTelefoneDeContato());
        dados.put("curso", pessoa.getNomeCursoDesejado());

        salvarObjeto("lista", dados);
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

        if (firstName.equals("") || secondName.equals("") || phone.equals("")) {
            throw new Exception("Não há dados salvos.");
        } else {
            return new Pessoa(firstName, secondName, phone, course);
        }
    }
}
