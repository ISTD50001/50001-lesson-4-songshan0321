package com.example.norman_lee.displayingdatanew;

import android.provider.BaseColumns;

/**
 * Created by norman_lee on 6/10/17.
 */

public class CharaContract {

    //TODO 7.1 Examine the static inner classes. No coding is needed

    //TODO 7.2 Prevent Instantiation of this Contract class
    private CharaContract() {
    }

    public static final class CharaEntry implements BaseColumns {

        public static final String TABLE_NAME = "Chara";
        public static final String COL_NAME = "name";
        public static final String COL_DESCRIPTION = "description";
        public static final String COL_FILE = "file";

    }

    public static final class CharaSql {

        public static String SPACE = " ";
        public static String COMMA = ",";

        public static String SQL_CREATE_TABLE = "CREATE TABLE" + SPACE
                + CharaEntry.TABLE_NAME + SPACE + "("
                + CharaEntry._ID + SPACE + "INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA
                + CharaEntry.COL_NAME + SPACE + "TEXT NOT NULL" + COMMA
                + CharaEntry.COL_DESCRIPTION + SPACE + "TEXT NOT NULL" + COMMA
                + CharaEntry.COL_FILE + SPACE + "BLOB NOT NULL" + ");" ;

        public static String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + CharaEntry.TABLE_NAME;

        public static String SQL_QUERY_ONE_RANDOM_ROW = "SELECT * FROM" + SPACE
                + CharaEntry.TABLE_NAME + SPACE
                + "ORDER BY RANDOM() LIMIT 1";

        public static String SQL_QUERY_ALL_ROWS = "SELECT * FROM " + CharaEntry.TABLE_NAME;

    }
}
