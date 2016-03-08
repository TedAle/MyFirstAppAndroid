package com.example.ted.myapplication.model;

import android.content.ContentValues;

import java.util.ArrayList;

/**
 * Created by Ted on 07/03/2016.
 */
public class MockInsertTanks {

    public static ArrayList<ContentValues> getTanksContentValues(){
        ArrayList listCV = new ArrayList<ContentValues>();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WoTChartsEntry.NAME, "tank1");
        values.put(WoTChartsEntry.NATION, "US");
        values.put(WoTChartsEntry.CLASS, "light");
        values.put(WoTChartsEntry.TIER, "1");
        values.put(WoTChartsEntry.SHIELD, "100");
        values.put(WoTChartsEntry.FIRE_POWER, "12.5");
        //values.put(WoTChartsEntry.COLUMN_NAME, content);
        listCV.add(values);

        ContentValues values2 = new ContentValues();
        values2.put(WoTChartsEntry.NAME, "tank2");
        values2.put(WoTChartsEntry.NATION, "US");
        values2.put(WoTChartsEntry.CLASS, "light");
        values2.put(WoTChartsEntry.TIER, "2");
        values2.put(WoTChartsEntry.SHIELD, "85");
        values2.put(WoTChartsEntry.FIRE_POWER, "20.5");
        listCV.add(values2);

        ContentValues values3 = new ContentValues();
        values3.put(WoTChartsEntry.NAME, "tank3");
        values3.put(WoTChartsEntry.NATION, "US");
        values3.put(WoTChartsEntry.CLASS, "medium");
        values3.put(WoTChartsEntry.TIER, "1");
        values3.put(WoTChartsEntry.SHIELD, "200");
        values3.put(WoTChartsEntry.FIRE_POWER, "22.5");
        listCV.add(values3);

        ContentValues values4 = new ContentValues();
        values4.put(WoTChartsEntry.NAME, "tank4");
        values4.put(WoTChartsEntry.NATION, "US");
        values4.put(WoTChartsEntry.CLASS, "medium");
        values4.put(WoTChartsEntry.TIER, "2");
        values4.put(WoTChartsEntry.SHIELD, "215");
        values4.put(WoTChartsEntry.FIRE_POWER, "28.5");
        listCV.add(values4);

        ///////////////////////////////////////////////////////////////////////////////////////////

        ContentValues values5 = new ContentValues();
        values5.put(WoTChartsEntry.NAME, "tank5");
        values5.put(WoTChartsEntry.NATION, "US");
        values5.put(WoTChartsEntry.CLASS, "heavy");
        values5.put(WoTChartsEntry.TIER, "1");
        values5.put(WoTChartsEntry.SHIELD, "200");
        values5.put(WoTChartsEntry.FIRE_POWER, "22.5");
        listCV.add(values5);

        ContentValues values6 = new ContentValues();
        values6.put(WoTChartsEntry.NAME, "tank6");
        values6.put(WoTChartsEntry.NATION, "US");
        values6.put(WoTChartsEntry.CLASS, "heavy");
        values6.put(WoTChartsEntry.TIER, "2");
        values6.put(WoTChartsEntry.SHIELD, "215");
        values6.put(WoTChartsEntry.FIRE_POWER, "28.5");
        listCV.add(values6);

        ////////////////////////////////////////////////////////////////////////////////////////////

        ContentValues values7 = new ContentValues();
        values7.put(WoTChartsEntry.NAME, "tank7");
        values7.put(WoTChartsEntry.NATION, "URSS");
        values7.put(WoTChartsEntry.CLASS, "light");
        values7.put(WoTChartsEntry.TIER, "1");
        values7.put(WoTChartsEntry.SHIELD, "20");
        values7.put(WoTChartsEntry.FIRE_POWER, "6.5");
        //values.put(WoTChartsEntry.COLUMN_NAME, content);
        listCV.add(values7);

        ContentValues values8 = new ContentValues();
        values8.put(WoTChartsEntry.NAME, "tank8");
        values8.put(WoTChartsEntry.NATION, "URSS");
        values8.put(WoTChartsEntry.CLASS, "light");
        values8.put(WoTChartsEntry.TIER, "2");
        values8.put(WoTChartsEntry.SHIELD, "35");
        values8.put(WoTChartsEntry.FIRE_POWER, "7.5");
        listCV.add(values8);

        ContentValues values9 = new ContentValues();
        values9.put(WoTChartsEntry.NAME, "tank9");
        values9.put(WoTChartsEntry.NATION, "URSS");
        values9.put(WoTChartsEntry.CLASS, "medium");
        values9.put(WoTChartsEntry.TIER, "1");
        values9.put(WoTChartsEntry.SHIELD, "50");
        values9.put(WoTChartsEntry.FIRE_POWER, "12.5");
        //values.put(WoTChartsEntry.COLUMN_NAME, content);
        listCV.add(values9);

        ContentValues values10 = new ContentValues();
        values10.put(WoTChartsEntry.NAME, "tank10");
        values10.put(WoTChartsEntry.NATION, "URSS");
        values10.put(WoTChartsEntry.CLASS, "medium");
        values10.put(WoTChartsEntry.TIER, "2");
        values10.put(WoTChartsEntry.SHIELD, "75");
        values10.put(WoTChartsEntry.FIRE_POWER, "18.5");
        listCV.add(values10);

        ContentValues values11 = new ContentValues();
        values11.put(WoTChartsEntry.NAME, "tank11");
        values11.put(WoTChartsEntry.NATION, "URSS");
        values11.put(WoTChartsEntry.CLASS, "heavy");
        values11.put(WoTChartsEntry.TIER, "1");
        values11.put(WoTChartsEntry.SHIELD, "200");
        values11.put(WoTChartsEntry.FIRE_POWER, "22.5");
        //values.put(WoTChartsEntry.COLUMN_NAME, content);
        listCV.add(values11);

        ContentValues values12 = new ContentValues();
        values12.put(WoTChartsEntry.NAME, "tank12");
        values12.put(WoTChartsEntry.NATION, "URSS");
        values12.put(WoTChartsEntry.CLASS, "heavy");
        values12.put(WoTChartsEntry.TIER, "2");
        values12.put(WoTChartsEntry.SHIELD, "315");
        values12.put(WoTChartsEntry.FIRE_POWER, "38.5");
        listCV.add(values12);


        return listCV;
    }
}
