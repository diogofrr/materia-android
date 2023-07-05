package devandroid.diogoferreira.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.diogoferreira.appgaseta.model.Gaseta;
import devandroid.diogoferreira.appgaseta.view.GasetaActivity;

public class GasetaController {    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_gaseta";
    SharedPreferences.Editor gaseta;


    public GasetaController(GasetaActivity gasetaActivity) {
        preferences = gasetaActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        gaseta = preferences.edit();
    }

    public void saveAction() {
        gaseta.putString("gasolina", pessoa.getPrimeiroNome());
        gaseta.putString("etanol", pessoa.getSegundoNome());
        gaseta.apply();
    }

    public void clearAction() {
        gaseta.clear();
        gaseta.apply();
    }

    public Gaseta findAction() throws Exception {
        String gasolina = preferences.getString("gasolina", "");
        String etanol = preferences.getString("etanol", "");
        try {
            double gasolinaDouble = Double.parseDouble(gasolina);
            double etanolDouble = Double.parseDouble(etanol);

            if (gasolina.equals("") || etanol.equals("")) {
                throw new Exception("Não há dados salvos.");
            } else {
                return new Gaseta(gasolinaDouble, etanolDouble);
            }
        } catch (NumberFormatException e) {
            Log.i("GasetaAPP", "Erro ao tentar usar casting nos dados.");
        } catch (Exception e) {
            Log.i("GasetaAPP", e.getMessage());
        }

        return null;
    }

}
