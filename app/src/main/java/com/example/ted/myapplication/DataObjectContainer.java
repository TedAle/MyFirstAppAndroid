package com.example.ted.myapplication;

import java.util.ArrayList;

/**
 * Created by Ted on 03/03/2016.
 */
public class DataObjectContainer {

    private static ArrayList<DataObject> datas;

    public static void initDatas() {
        datas = new ArrayList<DataObject>();
        for (int i = 0; i < 20; i++) {
            DataObject obj;
            if (i % 2 == 0) {
                obj = new DataObject("Name " + i, "Description " + i);
                obj.setBigImage(R.color.colorPrimary);
            } else {
                obj = new DataObject("Name D " + i, "Description D " + i);
                obj.setBigImage(R.color.colorPrimaryDark);
            }
            datas.add(i, obj);
        }
    }

    public static ArrayList<DataObject> getDatas() {
        if (datas == null) {
            initDatas();
        }
        return datas;
    }

    public static void setDatas(ArrayList<DataObject> datas) {
        DataObjectContainer.datas = datas;
    }

    public static void destroyDatas() {
        datas.clear();
    }
}
