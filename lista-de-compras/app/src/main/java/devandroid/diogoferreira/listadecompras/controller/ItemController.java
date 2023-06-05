package devandroid.diogoferreira.listadecompras.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.listadecompras.MainActivity;
import devandroid.diogoferreira.listadecompras.model.Item;

public class ItemController {

    private final ArrayList<Item> itens = new ArrayList<>();
    public static final String NOME_PREFERENCES = "pref_listaItens";

    SharedPreferences preferences;
    SharedPreferences.Editor listaItens;

    public ItemController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaItens = preferences.edit();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Item controller iniciado");
        return super.toString();
    }

    public void saveItemAction(Item newItem){
        listaItens.putString("name", newItem.getName());
        listaItens.putString("quantity", newItem.getQuantity());
        listaItens.putString("shop", newItem.getShop());
        listaItens.apply();

        this.itens.add(newItem);
    }

    public void clearAction() {
        listaItens.clear();
        listaItens.apply();
    }

    public Item findAction() throws Exception {
        String name = preferences.getString("name", "");
        String quantity = preferences.getString("quantity", "");
        String shop = preferences.getString("shop", "");

        if (name.equals("") || quantity.equals("") || shop.equals("")) {
            throw new Exception("Não há dados salvos.");
        } else {
            return new Item(name, quantity, shop);
        }
    }

}




