package com.example.ted.myapplication.model.utils;

import com.example.ted.myapplication.model.WoTChartsEntry;

import java.util.ArrayList;

/**
 * Created by Ted on 18/03/2016.
 */
public class FiltersManager {

    public static final String US = "US";
    public static final String UK = "UK";
    public static final String URSS = "URSS";
    public static final String FR = "FR";
    public static final String JP = "JP";
    public static final String CHINA = "CHINA";
    public static final String CHZ = "CHZ";
    public static final String DK = "DK";


    public static final String C1 = "C1";
    public static final String C2 = "C2";
    public static final String C3 = "C3";
    public static final String C4 = "C4";


    public static final String T1 = "T1";
    public static final String T2 = "T2";
    public static final String T3 = "T3";
    public static final String T4 = "T4";
    public static final String T5 = "T5";
    public static final String T6 = "T6";
    public static final String T7 = "T7";
    public static final String T8 = "T8";
    public static final String T9 = "T9";
    public static final String T10 = "T10";

    public static String createWhereNation(ArrayList<String> nations) {
        String where = "";
        if (nations!=null && nations.size()>0) {
            where = WoTChartsEntry.NATION + "IN {?}";
        }
        return where;
    }

    public static String createWhereClasse(ArrayList<String> classes) {
        String where = "";
        if (classes!=null && classes.size()>0) {
            where = WoTChartsEntry.CLASS + "IN {?}";
        }
        return where;
    }

    public static String createWhereTier(ArrayList<String> tiers) {
        String where = "";
        if (tiers!=null && tiers.size()>0) {
            where = WoTChartsEntry.TIER + "IN {?}";
        }
        return where;
    }
}
