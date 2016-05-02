package com.example.ted.myapplication;

import android.support.v4.app.FragmentActivity;

import java.util.HashMap;

/**
 * Created by Ted on 03/03/2016.
 */
public class DemoBase extends FragmentActivity {


    public enum RadarKindEnum {
        FIREPOWER("Firepower"), ARMOR("Armor"), HIT_POINTS("Hit Points"), HULL_ARMOR("Hull Armor"), TURRET_ARMOR("Turret Armor"),
        MOBILITY("Mobility"), CONCEALMENT("Concealment"), SPOTTING("Spotting"), ARMAMENT("Armament"), GENERAL("General");

        private String description;

        RadarKindEnum(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    protected static String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    protected static String[] mParties = new String[]{
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

    protected static String[] Modules = new String[]{"Guns", "Turrets", "Engines", "Suspensions", "Radios"};

    protected static String[] Mobility = new String[]{"Engine Power", "Speed Limit", "Traverse", "Power/Wt Ratio", "Pivot"};

    protected static String[] Armor = new String[]{"Hull Front", "Hull Side", "Hull Back", "Turret Front", "Turret Side", "Turret Back"};

    protected static String[] Armament = new String[]{"Shells", "Shell Cost", "Damage", "Penetration", "Rate of Fire", "Damage Per Minute"
            , "Accuracy", "Aim time", "Turret Traverse", "Gun Arc", "Elevation Arc", "Ammo Capacity"};

    protected static String[] General = new String[]{"Chance of Fire", "View Range", "Signal Range"};


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }

}
