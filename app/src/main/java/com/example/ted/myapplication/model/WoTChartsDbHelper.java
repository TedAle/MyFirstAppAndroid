package com.example.ted.myapplication.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ted on 06/03/2016.
 */
public class WoTChartsDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String BOOL_TYPE = " BOOLEAN";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + WoTChartsEntry.TABLE_NAME + " (" +
                    WoTChartsEntry._ID + " INTEGER PRIMARY KEY," +
                    WoTChartsEntry.NAME + TEXT_TYPE + COMMA_SEP +
                    WoTChartsEntry.NATION + TEXT_TYPE + COMMA_SEP +
                    WoTChartsEntry.CLASS + TEXT_TYPE + COMMA_SEP +
                    WoTChartsEntry.TIER + TEXT_TYPE + COMMA_SEP +
                    WoTChartsEntry.PREMIUM + BOOL_TYPE + COMMA_SEP +
                    WoTChartsEntry.SHIELD + TEXT_TYPE + COMMA_SEP +
                    WoTChartsEntry.FIRE_POWER + TEXT_TYPE +
                    " );";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + WoTChartsEntry.TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WoTCharts.db";

    public WoTChartsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}