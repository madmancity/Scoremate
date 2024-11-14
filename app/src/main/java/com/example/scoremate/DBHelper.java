package com.example.scoremate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mlbteams.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "teams";
    public static final String COLUMN_ID = "team";
    public static final String  COLUMN_VALUE_1 = "lat";
    public static final String COLUMN_VALUE_2 = "long";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " TEXT PRIMARY KEY, " +
                COLUMN_VALUE_1 + " REAL, " +
                COLUMN_VALUE_2 + " REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

