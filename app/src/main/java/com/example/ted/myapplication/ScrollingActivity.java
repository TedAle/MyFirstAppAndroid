package com.example.ted.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.RadarChart;

public class ScrollingActivity extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        //TODO
        Intent intent = getIntent();
        Integer posDataObject = Integer.parseInt((String) intent.getExtras().get(EXTRA_MESSAGE));

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        int logo = DataObjectContainer.getDatas().get(posDataObject).getBigImage();
        //COLORE DELLA TOOLBARD DA COLLASSATA
        //collapsingToolbarLayout.setContentScrim(getResources().getDrawable(logo));
        /*IMPOSTO LA BIG IMAGE*/
        ((ImageView) findViewById(R.id.img_toolbar)).setImageDrawable(getResources().getDrawable(logo));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        String title = DataObjectContainer.getDatas().get(posDataObject).getName();
        toolbar.setTitle(title);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(DataObjectContainer.getDatas().get(posDataObject).getDetail());

        RadarChart mChart = (RadarChart) findViewById(R.id.chart1);
        //Typeface tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        RadarClass.getRadar(mChart, null, null);

        RadarChart mChart2 = (RadarChart) findViewById(R.id.chart2);
        RadarClass.getRadar(mChart2, null, null);

        RadarChart mChart3 = (RadarChart) findViewById(R.id.chart3);
        RadarClass.getRadar(mChart3, null, null);
    }
}
