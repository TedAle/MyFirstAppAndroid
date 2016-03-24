package com.example.ted.myapplication.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ted.myapplication.model.utils.FiltersManager;

import java.util.ArrayList;

/**
 * Created by Ted on 06/03/2016.
 */
public class MockDB {

    public static final String orderBy = WoTChartsEntry.NATION + "," + WoTChartsEntry.CLASS + "," + WoTChartsEntry.TIER;


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

    public static ArrayList<Tank> getTankAll(WoTChartsDbHelper mDbHelper) {

        ArrayList<Tank> result;
        String where_condition = null;
        String[] where_values = {};
        result = getTank(mDbHelper, where_condition, where_values, null, null, orderBy, null);
        return result;
    }

    public static ArrayList<Tank> getTankByNation(WoTChartsDbHelper mDbHelper, String nation) {

        ArrayList<Tank> result = new ArrayList<Tank>();
        String where_condition = WoTChartsEntry.NATION + "IN {?}";
        String[] where_values = new String[]{nation};
        result = getTank(mDbHelper, where_condition, where_values, null, null, orderBy, null);
        return result;
    }

    public static ArrayList<Tank> getTank(WoTChartsDbHelper mDbHelper, ArrayList<String> nations, ArrayList<String> classes, ArrayList<String> tiers) {
        ArrayList<Tank> result = new ArrayList<>();
        String col_where;

        String col_where_nat = FiltersManager.createWhereNation(nations);
        String col_where_cla = FiltersManager.createWhereClasse(classes);
        String col_where_tie = FiltersManager.createWhereTier(tiers);

        col_where = createWhereClause(col_where_nat, col_where_cla, col_where_tie);

        String[] val_where = createWhereArgs(nations, classes, tiers);

        getTank(mDbHelper, col_where, val_where, (String) null, (String) null, orderBy, (String) null);
        return result;
    }

    private static String[] createWhereArgs(ArrayList<String> col_where_nat, ArrayList<String> col_where_cla, ArrayList<String> col_where_tie) {
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(col_where_nat);
        result.addAll(col_where_cla);
        result.addAll(col_where_tie);

        return (String[]) result.toArray();
    }

    private static String createWhereClause(String col_where_nat, String col_where_cla, String col_where_tie) {
        String where = "";
        if (col_where_nat != null && col_where_nat.length() > 0) {
            where = where + col_where_nat;
        }
        if (col_where_cla != null && col_where_cla.length() > 0) {
            if (where.length() > 0) {
                where = where + " AND ";
            }
            where = col_where_cla;
        }
        if (col_where_tie != null && col_where_tie.length() > 0) {
            if (where.length() > 0) {
                where = where + " AND ";
            }
            where = col_where_tie;
        }
        if (where.length() == 0) {
            return null;
        }
        return where;
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

        //TODO creare la query per l'estrazione dei dati dal db
        Cursor c = db.query(
                WoTChartsEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                col_where,//selection,                    // The columns for the WHERE clause
                val_where,//selectionArgs,                // The values for the WHERE clause
                groupBy,                                  // don't group the rows
                having,                                   // don't filter by row groups
                orderBy,                                  // The sort order
                limit                                     // The max limit of rows returned by the query
        );

        StringBuilder builder_values_where = new StringBuilder();
        if (val_where != null) {
            for (String val : val_where) {
                builder_values_where.append(val + ", ");
            }
            if (val_where.length > 0) {
                String values_where = builder_values_where.substring(0, builder_values_where.toString().length() - ", ".length()).toString();
            }
        }
        //Cursor c = db.rawQuery("SELECT * FROM " + WoTChartsEntry.TABLE_NAME + " WHERE NATION IN (" + values_where + ")", null);


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
