package devandroid.diogoferreira.aplicativolistadecompras.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import devandroid.diogoferreira.aplicativolistadecompras.model.Item;
import devandroid.diogoferreira.aplicativolistadecompras.database.ItemContract;
import devandroid.diogoferreira.aplicativolistadecompras.database.ItemDbHelper;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListController {
    private ItemDbHelper dbHelper;

    public ShoppingListController(Context context) {
        dbHelper = new ItemDbHelper(context);
    }

    public long addItem(String name, int quantity) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.COLUMN_NAME, name);
        values.put(ItemContract.ItemEntry.COLUMN_QUANTITY, quantity);
        return db.insert(ItemContract.ItemEntry.TABLE_NAME, null, values);
    }

    public List<Item> getAllItems() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                ItemContract.ItemEntry._ID,
                ItemContract.ItemEntry.COLUMN_NAME,
                ItemContract.ItemEntry.COLUMN_QUANTITY
        };
        Cursor cursor = db.query(
                ItemContract.ItemEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        List<Item> itemList = new ArrayList<>();
        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(ItemContract.ItemEntry._ID));
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(ItemContract.ItemEntry.COLUMN_NAME));
            int itemQuantity = cursor.getInt(cursor.getColumnIndexOrThrow(ItemContract.ItemEntry.COLUMN_QUANTITY));
            itemList.add(new Item(itemId, itemName, itemQuantity));
        }
        cursor.close();
        return itemList;
    }

    public void deleteItem(long itemId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = ItemContract.ItemEntry._ID + "=?";
        String[] selectionArgs = {String.valueOf(itemId)};
        db.delete(ItemContract.ItemEntry.TABLE_NAME, selection, selectionArgs);
    }
}
