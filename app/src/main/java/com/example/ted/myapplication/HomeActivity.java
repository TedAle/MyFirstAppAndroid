package com.example.ted.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.ted.myapplication.model.MockDB;
import com.example.ted.myapplication.model.Tank;
import com.example.ted.myapplication.model.WoTChartsDbHelper;
import com.example.ted.myapplication.model.utils.FiltersManager;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    WoTChartsDbHelper mDbHelper;
    ArrayList<Tank> tankUS;
    ArrayList<Tank> tankURSS;
    ArrayList<Tank> tankUK;
    ArrayList<Tank> tankFR;
    ArrayList<Tank> tankCHINA;
    ArrayList<Tank> tankCHZ;
    ArrayList<Tank> tankJP;
    ArrayList<Tank> tankDK;
    ArrayList<Tank> tankAll;

    Boolean flUS = Boolean.FALSE, flURSS = Boolean.FALSE, flUK = Boolean.FALSE, flFR = Boolean.FALSE, flCHINA = Boolean.FALSE, flJP = Boolean.FALSE, flDK = Boolean.FALSE, flCHZ = Boolean.FALSE, flC1 = Boolean.FALSE, flC2 = Boolean.FALSE, flC3 = Boolean.FALSE, flC4 = Boolean.FALSE,
            flT1 = Boolean.FALSE, flT2 = Boolean.FALSE, flT3 = Boolean.FALSE, flT4 = Boolean.FALSE, flT5 = Boolean.FALSE, flT6 = Boolean.FALSE, flT7 = Boolean.FALSE, flT8 = Boolean.FALSE, flT9 = Boolean.FALSE, flT10 = Boolean.FALSE;


    ToggleButton us;
    ToggleButton urss;
    ToggleButton uk;
    ToggleButton fr;
    ToggleButton china;
    ToggleButton jp;
    ToggleButton dk;
    ToggleButton chz;

    ToggleButton class1;
    ToggleButton class2;
    ToggleButton class3;
    ToggleButton class4;

    ToggleButton tier1;
    ToggleButton tier2;
    ToggleButton tier3;
    ToggleButton tier4;
    ToggleButton tier5;
    ToggleButton tier6;
    ToggleButton tier7;
    ToggleButton tier8;
    ToggleButton tier9;
    ToggleButton tier10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDbHelper = new WoTChartsDbHelper(getApplicationContext());
        tankAll = MockDB.getTankAll(mDbHelper);
        tankUS = new ArrayList<>();
        tankURSS = new ArrayList<>();
        tankUK = new ArrayList<>();
        tankFR = new ArrayList<>();
        tankCHINA = new ArrayList<>();
        tankCHZ = new ArrayList<>();
        tankJP = new ArrayList<>();
        tankDK = new ArrayList<>();
        extractTanks();
//        tankUS = extractTankByNation(tankAll, "US");
//        tankURSS = extractTankByNation(tankAll, "URSS");
//        tankUK = extractTankByNation(tankAll, "UK");
//        tankFR = extractTankByNation(tankAll, "FR");
//        tankCHINA = extractTankByNation(tankAll, "CHINA");
//        tankCHZ = extractTankByNation(tankAll, "CHZ");
//        tankJP = extractTankByNation(tankAll, "JP");
//        tankDK = extractTankByNation(tankAll, "DK");


        initView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> nations = createWhereNation();
                ArrayList<String> classes = createWhereClasse();
                ArrayList<String> tiers = createWhereTier();
                ArrayList<Tank> result;
                result = shortcutSearch(nations, classes, tiers);
                if (result == null) {
                    if (nations.size() == 0 && classes.size() == 0 && tiers.size() == 0) {
                        result = tankAll;
                    } else {
                        WoTChartsDbHelper mDbHelper = new WoTChartsDbHelper(getApplicationContext());
                        result = checkSearchFilter(mDbHelper, nations, classes, tiers);
                    }
                }
                for (Tank tank : result) {
                    Log.i("Home Activity", tank.toString());
                }
                Snackbar.make(view, "Finded " + result.size() + " tanks", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //    TODO selectClassList AND selectTierList
    private ArrayList<Tank> shortcutSearch(ArrayList<String> nations, ArrayList<String> classes, ArrayList<String> tiers) {
        if (nations.size() != 0 && classes.size() == 0 && tiers.size() == 0) {
            return selectNationList(nations);
        } else if (nations.size() == 0 && classes.size() != 0 && tiers.size() == 0) {
//            TODO
            return null;
        } else if (nations.size() == 0 && classes.size() == 0 && tiers.size() != 0) {
//            TODO
            return null;
        }
        return null;
    }

    private ArrayList<Tank> selectNationList(ArrayList<String> nations) {
        ArrayList<Tank> result = new ArrayList<>();
        for (String nat : nations) {
            if (FiltersManager.US.equalsIgnoreCase(nat)) {
                result.addAll(tankUS);
            } else if (FiltersManager.UK.equalsIgnoreCase(nat)) {
                result.addAll(tankUK);
            } else if (FiltersManager.URSS.equalsIgnoreCase(nat)) {
                result.addAll(tankURSS);
            } else if (FiltersManager.FR.equalsIgnoreCase(nat)) {
                result.addAll(tankFR);
            } else if (FiltersManager.JP.equalsIgnoreCase(nat)) {
                result.addAll(tankJP);
            } else if (FiltersManager.CHINA.equalsIgnoreCase(nat)) {
                result.addAll(tankCHINA);
            } else if (FiltersManager.CHZ.equalsIgnoreCase(nat)) {
                result.addAll(tankCHZ);
            } else if (FiltersManager.DK.equalsIgnoreCase(nat)) {
                result.addAll(tankDK);
            }
        }

        return result;
    }

//TODO selectClassList
//    private ArrayList<Tank> selectClassList(ArrayList<String> nations) {
//        ArrayList<Tank> result = new ArrayList<Tank>();
//        for (String nat : nations) {
//            if (FiltersManager.C1.equalsIgnoreCase(nat)) {
//                result.addAll(tankC1);
//            } else if (FiltersManager.C2.equalsIgnoreCase(nat)) {
//                result.addAll(tankC2);
//            } else if (FiltersManager.C3.equalsIgnoreCase(nat)) {
//                result.addAll(tankC3);
//            } else if (FiltersManager.C4.equalsIgnoreCase(nat)) {
//                result.addAll(tankC4);
//            }
//        }
//        return result;
//    }

//TODO selectTierList
//    private ArrayList<Tank> selectTierList(ArrayList<String> nations) {
//        ArrayList<Tank> result = new ArrayList<Tank>();
//        for (String nat : nations) {
//            if (FiltersManager.T1.equalsIgnoreCase(nat)) {
//                result.addAll(tankT1);
//            } else if (FiltersManager.T2.equalsIgnoreCase(nat)) {
//                result.addAll(tankT2);
//            } else if (FiltersManager.T3.equalsIgnoreCase(nat)) {
//                result.addAll(tankT3);
//            } else if (FiltersManager.T4.equalsIgnoreCase(nat)) {
//                result.addAll(tankT4);
//            } else if (FiltersManager.T5.equalsIgnoreCase(nat)) {
//                result.addAll(tankT5);
//            } else if (FiltersManager.T6.equalsIgnoreCase(nat)) {
//                result.addAll(tankT6);
//            } else if (FiltersManager.T7.equalsIgnoreCase(nat)) {
//                result.addAll(tankT7);
//            } else if (FiltersManager.T8.equalsIgnoreCase(nat)) {
//                result.addAll(tankT8);
//            } else if (FiltersManager.T9.equalsIgnoreCase(nat)) {
//                result.addAll(tankT9);
//            } else if (FiltersManager.T10.equalsIgnoreCase(nat)) {
//                result.addAll(tankT10);
//            }
//        }
//        return result;
//    }


    private ArrayList<Tank> extractTankByNation(ArrayList<Tank> tankAll, String nation) {
        ArrayList<Tank> result = new ArrayList<>();
        for (Tank tank : tankAll) {
            if (nation.equalsIgnoreCase(tank.getNation())) {
                result.add(tank);
            }
        }
        return result;
    }

    private ArrayList<Tank> extractTankByClass(ArrayList<Tank> tankAll, String classe) {
        ArrayList<Tank> result = new ArrayList<>();
        for (Tank tank : tankAll) {
            if (classe.equalsIgnoreCase(tank.getClasse())) {
                result.add(tank);
            }
        }
        return result;
    }

    private ArrayList<Tank> extractTankByTier(ArrayList<Tank> tankAll, String tier) {
        ArrayList<Tank> result = new ArrayList<>();
        for (Tank tank : tankAll) {
            if (tier.equalsIgnoreCase(tank.getTier())) {
                result.add(tank);
            }
        }
        return result;
    }

    private ArrayList<Tank> checkSearchFilter(WoTChartsDbHelper mDbHelper, ArrayList<String> nations, ArrayList<String> classes, ArrayList<String> tiers) {
        ArrayList<Tank> result;
        //TODO SEARCH TANK
        result = MockDB.getTank(mDbHelper, nations, classes, tiers);
        return result;
    }


    private void initView() {
        us = (ToggleButton) findViewById(R.id.us);
        us.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flUS, R.drawable.ic_usa_flag_disabled, R.drawable.ic_usa_flag_pressed);
                flUS = !flUS;
            }
        });
        urss = (ToggleButton) findViewById(R.id.urss);
        urss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flURSS, R.drawable.ic_ussr_flag_disabled, R.drawable.ic_ussr_flag_pressed);
                flURSS = !flURSS;
            }
        });
        uk = (ToggleButton) findViewById(R.id.uk);
        uk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flUK, R.drawable.ic_uk_flag_disabled, R.drawable.ic_uk_flag_pressed);
                flUK = !flUK;
            }
        });
        fr = (ToggleButton) findViewById(R.id.fr);
        fr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flFR, R.drawable.ic_french_flag_disabled, R.drawable.ic_french_flag_pressed);
                flFR = !flFR;
            }
        });
        china = (ToggleButton) findViewById(R.id.china);
        china.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flCHINA, R.drawable.ic_china_flag_disabled, R.drawable.ic_china_flag_pressed);
                flCHINA = !flCHINA;
            }
        });
        jp = (ToggleButton) findViewById(R.id.jp);
        jp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flJP, R.drawable.ic_japan_flag_disabled, R.drawable.ic_japan_flag_pressed);
                flJP = !flJP;
            }
        });
        dk = (ToggleButton) findViewById(R.id.dk);
        dk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flDK, R.drawable.ic_germany_flag_disabled, R.drawable.ic_germany_flag_pressed);
                flDK = !flDK;
            }
        });
        chz = (ToggleButton) findViewById(R.id.chz);
        chz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeImage(buttonView, flCHZ, R.drawable.ic_czechoslovakia_flag_disabled, R.drawable.ic_czechoslovakia_flag_pressed);
                flCHZ = !flCHZ;
            }
        });

        class1 = (ToggleButton) findViewById(R.id.class1);
        class1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flC1 = !flC1;
            }
        });

        class2 = (ToggleButton) findViewById(R.id.class2);
        class2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flC2 = !flC2;
            }
        });

        class3 = (ToggleButton) findViewById(R.id.class3);
        class3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flC3 = !flC3;
            }
        });

        class4 = (ToggleButton) findViewById(R.id.class4);
        class4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flC4 = !flC4;
            }
        });

        tier1 = (ToggleButton) findViewById(R.id.tier1);
        tier1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT1 = !flT1;
            }
        });

        tier2 = (ToggleButton) findViewById(R.id.tier2);
        tier2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT2 = !flT2;
            }
        });

        tier3 = (ToggleButton) findViewById(R.id.tier3);
        tier3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT3 = !flT3;
            }
        });

        tier4 = (ToggleButton) findViewById(R.id.tier4);
        tier4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT4 = !flT4;
            }
        });

        tier5 = (ToggleButton) findViewById(R.id.tier5);
        tier5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT5 = !flT5;
            }
        });

        tier6 = (ToggleButton) findViewById(R.id.tier6);
        tier6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT6 = !flT6;
            }
        });

        tier7 = (ToggleButton) findViewById(R.id.tier7);
        tier7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT7 = !flT7;
            }
        });

        tier8 = (ToggleButton) findViewById(R.id.tier8);
        tier8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT8 = !flT8;
            }
        });

        tier9 = (ToggleButton) findViewById(R.id.tier9);
        tier9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT9 = !flT9;
            }
        });

        tier10 = (ToggleButton) findViewById(R.id.tier10);
        tier10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flT10 = !flT10;
            }
        });

    }

    private void changeImage(CompoundButton v, Boolean flag, int _idTrue, int _idFalse) {
        if (flag) {
            v.setBackgroundResource(_idTrue);
//            v.set
        } else {
            v.setBackgroundResource(_idFalse);
//            v.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
        }
    }

    private ArrayList<String> createWhereNation() {
        ArrayList<String> list = new ArrayList<>();

        if (flUS) {
            list.add(FiltersManager.US);
        }
        if (flUK) {
            list.add(FiltersManager.US);
        }
        if (flURSS) {
            list.add(FiltersManager.US);
        }
        if (flFR) {
            list.add(FiltersManager.US);
        }
        if (flCHINA) {
            list.add(FiltersManager.US);
        }
        if (flJP) {
            list.add(FiltersManager.US);
        }
        if (flDK) {
            list.add(FiltersManager.US);
        }
        if (flCHZ) {
            list.add(FiltersManager.US);
        }
        return list;
    }

    private ArrayList<String> createWhereClasse() {
        ArrayList<String> list = new ArrayList<>();

        if (flC1) {
            list.add(FiltersManager.C1);
        }
        if (flC2) {
            list.add(FiltersManager.C2);
        }
        if (flC3) {
            list.add(FiltersManager.C3);
        }
        if (flC4) {
            list.add(FiltersManager.C4);
        }


        return list;
    }

    private ArrayList<String> createWhereTier() {
        ArrayList<String> list = new ArrayList<>();

        if (flT1) {
            list.add(FiltersManager.T1);
        }
        if (flT2) {
            list.add(FiltersManager.T2);
        }
        if (flT3) {
            list.add(FiltersManager.T3);
        }
        if (flT4) {
            list.add(FiltersManager.T4);
        }
        if (flT5) {
            list.add(FiltersManager.T5);
        }
        if (flT6) {
            list.add(FiltersManager.T6);
        }
        if (flT7) {
            list.add(FiltersManager.T7);
        }
        if (flT8) {
            list.add(FiltersManager.T8);
        }
        if (flT9) {
            list.add(FiltersManager.T9);
        }
        if (flT10) {
            list.add(FiltersManager.T10);
        }

        return list;
    }

    /**
     * Extract all the tanks and insert them to the proper list by nation
     */
    private void extractTanks() {

        for (Tank tank : tankAll) {
            if (FiltersManager.CHINA.equalsIgnoreCase(tank.getNation())) {
                tankCHINA.add(tank);
            } else if (FiltersManager.CHZ.equalsIgnoreCase(tank.getNation())) {
                tankCHZ.add(tank);
            } else if (FiltersManager.DK.equalsIgnoreCase(tank.getNation())) {
                tankDK.add(tank);
            } else if (FiltersManager.FR.equalsIgnoreCase(tank.getNation())) {
                tankFR.add(tank);
            } else if (FiltersManager.JP.equalsIgnoreCase(tank.getNation())) {
                tankJP.add(tank);
            } else if (FiltersManager.US.equalsIgnoreCase(tank.getNation())) {
                tankUS.add(tank);
            } else if (FiltersManager.UK.equalsIgnoreCase(tank.getNation())) {
                tankUK.add(tank);
            } else if (FiltersManager.URSS.equalsIgnoreCase(tank.getNation())) {
                tankURSS.add(tank);
            }
        }
    }

}
