package devandroid.diogoferreira.listadecompras.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import devandroid.diogoferreira.listadecompras.model.Item;

public class ItemController {

    private final ArrayList<Item> itens = new ArrayList<>();

    public ItemController() {
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
        this.itens.add(newItem);
    }
}
