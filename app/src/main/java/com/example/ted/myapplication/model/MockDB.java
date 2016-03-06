package com.example.ted.myapplication.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Ted on 06/03/2016.
 */
public class MockDB {


    public static void initializeDBMock(WoTChartsDbHelper mDbHelper) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WoTChartsEntry.NAME, "tank1");
        values.put(WoTChartsEntry.SHIELD, "100");
        values.put(WoTChartsEntry.FIRE_POWER, "12.5");
        //values.put(WoTChartsEntry.COLUMN_NAME, content);

        ContentValues values2 = new ContentValues();
        values2.put(WoTChartsEntry.NAME, "tank2");
        values2.put(WoTChartsEntry.SHIELD, "75");
        values2.put(WoTChartsEntry.FIRE_POWER, "18.5");

        // Insert the new row, returning the primary key value of the new row
        long newRowId;

        newRowId = db.insert(WoTChartsEntry.TABLE_NAME, null, values);
        Log.d("MOCK_ DB", "New row inserted id:" + newRowId);

        newRowId = db.insert(WoTChartsEntry.TABLE_NAME, null, values2);
        Log.d("MOCK_ DB", "New row inserted id:" + newRowId);
    }

    public Cursor readData(WoTChartsDbHelper mDbHelper) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                WoTChartsEntry._ID,
                WoTChartsEntry.NAME,
                WoTChartsEntry.SHIELD,
                WoTChartsEntry.FIRE_POWER,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                WoTChartsEntry.NAME + " DESC";

        Cursor c = db.query(
                WoTChartsEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,//selection,                                // The columns for the WHERE clause
                null,//selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return null;

    }


}
