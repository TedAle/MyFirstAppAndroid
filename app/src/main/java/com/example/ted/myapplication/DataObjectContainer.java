package com.example.ted.myapplication;

import com.example.ted.myapplication.model.Tank;

import java.util.ArrayList;

/**
 * Created by Ted on 03/03/2016.
 */
public class DataObjectContainer {

    private static ArrayList<DataObject> datas;

    public static void initDatas(ArrayList<Tank> tanks) {
        datas = new ArrayList<DataObject>();
        int i = 0;
        for (Tank tank : tanks) {
            DataObject obj;
            obj = new DataObject(tank.getName(), tank.getDescription());
            obj.setBigImage(R.mipmap.default_big_image);
            //obj.setBigImage(tank.getImage());
            //obj.setIcon(tank.getThumbnail());

            datas.add(i, obj);
            i++;
        }
    }
/*
    private static String createDescription(Tank tank) {
        StringBuilder builder = new StringBuilder();
        builder.append("" + tank.getNation());
        builder.append(" C " + tank.getClasse());
        builder.append(" T " + tank.getTier());
        builder.append(" Shield " + tank.getShield());
        return builder.toString();
    }
*/
/*
    public static void initDatas() {
        datas = new ArrayList<DataObject>();
        for (int i = 0; i < 20; i++) {
            DataObject obj;
            if (i % 2 == 0) {
                obj = new DataObject("Name " + i, "Description " + i);
                obj.setBigImage(R.mipmap.default_big_image);
            } else {
                obj = new DataObject("Name D " + i, "Description D " + i);
                obj.setBigImage(R.color.colorPrimaryDark);
            }
            datas.add(i, obj);
        }
    }
*/
    public static ArrayList<DataObject> getDatas(ArrayList<Tank> tanks) {
        if (datas == null) {
            initDatas(tanks);
        }
        return datas;
    }

    public static ArrayList<DataObject> getDatas() {
        return datas;
    }

    public static void setDatas(ArrayList<DataObject> datas) {
        DataObjectContainer.datas = datas;
    }

    public static void destroyDatas() {
        datas.clear();
    }
}
