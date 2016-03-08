package com.example.ted.myapplication.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ted on 06/03/2016.
 */
public class MockDB {


    public static void initializeDBMock(WoTChartsDbHelper mDbHelper) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ArrayList<ContentValues> listInsert = MockInsertTanks.getTanksContentValues();

        // Insert the new row, returning the primary key value of the new row
        long newRowId;

        for (ContentValues cv : listInsert) {
            newRowId = db.insert(WoTChartsEntry.TABLE_NAME, null, cv);
            Log.d("MOCK_ DB", "New row inserted id:" + newRowId);
        }
    }

    public static Cursor readData(WoTChartsDbHelper mDbHelper) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                WoTChartsEntry._ID,
                WoTChartsEntry.NAME, WoTChartsEntry.NATION, WoTChartsEntry.CLASS, WoTChartsEntry.TIER,
                WoTChartsEntry.SHIELD, WoTChartsEntry.FIRE_POWER,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                WoTChartsEntry.NAME + " DESC";

        //TODO creare la query per l'estrazione dei dati dal db
        Cursor c = db.query(
                WoTChartsEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,//selection,                                // The columns for the WHERE clause
                null,//selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        // if Cursor is contains results
        if (c != null) {
            // move cursor to first row
            if (c.moveToFirst()) {
                do {
                    Log.d("MOCK_DB", "_ID: " + c.getColumnIndex(WoTChartsEntry._ID));
                    Log.d("MOCK_DB", "NAME: " + c.getColumnIndex(WoTChartsEntry.NAME));

                    Log.d("MOCK_DB", "NATION: " + c.getColumnIndex(WoTChartsEntry.NATION));
                    Log.d("MOCK_DB", "CLASS: " + c.getColumnIndex(WoTChartsEntry.CLASS));
                    Log.d("MOCK_DB", "TIER: " + c.getColumnIndex(WoTChartsEntry.TIER));

                    Log.d("MOCK_DB", "FIRE_POWER: " + c.getColumnIndex(WoTChartsEntry.FIRE_POWER));
                    Log.d("MOCK_DB", "SHIELD: " + c.getColumnIndex(WoTChartsEntry.SHIELD));
                } while (c.moveToNext());
            }
        }

        if (db != null && db.isOpen()) {
            db.close();
        }
        return c;

    }

    public static ArrayList<Tank> getTankByNation(WoTChartsDbHelper mDbHelper, String nation) {

        ArrayList<Tank> result = new ArrayList<Tank>();
        String where_condition = WoTChartsEntry.NATION + "=" + "?";
        String[] where_values = {"'" + nation + "'"};
        String orderBy = WoTChartsEntry.CLASS + "," + WoTChartsEntry.TIER;
        result = getTank(mDbHelper, where_condition, where_values, null, null, orderBy, null);
        return result;
    }


    public static ArrayList<Tank> getTank(WoTChartsDbHelper mDbHelper, String col_where, String[] val_where, String groupBy, String having, String orderBy, String limit) {

        ArrayList<Tank> result = new ArrayList<>();

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                WoTChartsEntry._ID,
                WoTChartsEntry.NAME, WoTChartsEntry.NATION, WoTChartsEntry.CLASS, WoTChartsEntry.TIER,
                WoTChartsEntry.SHIELD, WoTChartsEntry.FIRE_POWER,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                WoTChartsEntry.NAME + " DESC";

        //TODO creare la query per l'estrazione dei dati dal db
        Cursor c = db.query(
                WoTChartsEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                col_where,//selection,                    // The columns for the WHERE clause
                val_where,//selectionArgs,                // The values for the WHERE clause
                groupBy,                                  // don't group the rows
                having,                                   // don't filter by row groups
                sortOrder,                                // The sort order
                limit                                     // The max limit of rows returned by the query
        );

        Cursor c2 = db.rawQuery("SELECT * FROM " + WoTChartsEntry.TABLE_NAME + " WHERE NATION = 'US'", null);


        // if Cursor is contains results
        if (c != null) {
            // move cursor to first row
            if (c.moveToFirst()) {
                do {
                    Tank tank = new Tank();
                    Log.d("MOCK_DB", "_ID: " + c.getString(c.getColumnIndex(WoTChartsEntry._ID)));
                    tank.setId(String.valueOf(c.getInt(c.getColumnIndex(WoTChartsEntry._ID))));
                    Log.d("MOCK_DB", "NAME: " + c.getString(c.getColumnIndex(WoTChartsEntry.NAME)));
                    tank.setName(c.getString(c.getColumnIndex(WoTChartsEntry.NAME)));
                    Log.d("MOCK_DB", "NATION: " + c.getString(c.getColumnIndex(WoTChartsEntry.NATION)));
                    Log.d("MOCK_DB", "CLASS: " + c.getString(c.getColumnIndex(WoTChartsEntry.CLASS)));
                    Log.d("MOCK_DB", "TIER: " + c.getString(c.getColumnIndex(WoTChartsEntry.TIER)));
                    tank.setNation(c.getString(c.getColumnIndex(WoTChartsEntry.NATION)));
                    tank.setClasse(c.getString(c.getColumnIndex(WoTChartsEntry.CLASS)));
                    tank.setTier(c.getString(c.getColumnIndex(WoTChartsEntry.TIER)));

                    Log.d("MOCK_DB", "SHIELD: " + c.getString(c.getColumnIndex(WoTChartsEntry.SHIELD)));
                    tank.setShield(c.getString(c.getColumnIndex(WoTChartsEntry.SHIELD)));
                    Log.d("MOCK_DB", "FIRE_POWER: " + c.getString(c.getColumnIndex(WoTChartsEntry.FIRE_POWER)));
                    tank.setFirePower(c.getString(c.getColumnIndex(WoTChartsEntry.FIRE_POWER)));

                    result.add(tank);
                } while (c.moveToNext());
            }
        }

        if (db != null && db.isOpen()) {
            db.close();
        }

        return result;
    }
}
