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
        tankUS = MockDB.getTankByNation(mDbHelper, "US");
        tankURSS = MockDB.getTankByNation(mDbHelper, "URSS");
        tankUK = MockDB.getTankByNation(mDbHelper, "UK");
        tankFR = MockDB.getTankByNation(mDbHelper, "FR");
        tankCHINA = MockDB.getTankByNation(mDbHelper, "CHINA");
        tankCHZ = MockDB.getTankByNation(mDbHelper, "CHZ");
        tankJP = MockDB.getTankByNation(mDbHelper, "JP");
        tankDK = MockDB.getTankByNation(mDbHelper, "DK");

        initView();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WoTChartsDbHelper mDbHelper = new WoTChartsDbHelper(getApplicationContext());
                ArrayList<Tank> result = checkSearchFilter(mDbHelper);
                for (Tank tank : result){
                    Log.i("Home Activity", tank.toString());
                }
                Snackbar.make(view, "Search", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }

    private ArrayList<Tank> checkSearchFilter(WoTChartsDbHelper mDbHelper) {
        ArrayList<Tank> result = new ArrayList<Tank>();

        return result;
    }


    private void initView() {
        us = (ToggleButton) findViewById(R.id.us);
        us.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flUS = !flUS;
            }
        });
        urss = (ToggleButton) findViewById(R.id.urss);
        urss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flURSS = !flURSS;
            }
        });
        uk = (ToggleButton) findViewById(R.id.uk);
        uk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flUK = !flUK;
            }
        });
        fr = (ToggleButton) findViewById(R.id.fr);
        fr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flFR = !flFR;
            }
        });
        china = (ToggleButton) findViewById(R.id.china);
        china.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flCHINA = !flCHINA;
            }
        });
        jp = (ToggleButton) findViewById(R.id.jp);
        jp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flJP = !flJP;
            }
        });
        dk = (ToggleButton) findViewById(R.id.dk);
        dk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flDK = !flDK;
            }
        });
        chz = (ToggleButton) findViewById(R.id.chz);
        chz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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

}
