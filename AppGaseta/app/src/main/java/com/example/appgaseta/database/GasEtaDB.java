package com.example.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GasEtaDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nomeCombustivel VARCHAR(10), " +
            "precoCombustivel REAL, " +
            "resultado VARCHAR(100))";

    Cursor cursor;

    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_CREATE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
