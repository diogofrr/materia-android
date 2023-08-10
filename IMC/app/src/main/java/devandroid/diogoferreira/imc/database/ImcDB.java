package devandroid.diogoferreira.imc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImcDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "lista.db";
    private static final int DB_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE imc (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "peso REAL, " +
            "altura REAL, " +
            "resultado REAL)";

    SQLiteDatabase db;

    public ImcDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
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
