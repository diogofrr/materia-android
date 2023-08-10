package devandroid.diogoferreira.aplicativolistadecompras.database;

import android.provider.BaseColumns;

public final class ItemContract {
    private ItemContract() {}

    public static class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "shopping_list";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
    }
}
