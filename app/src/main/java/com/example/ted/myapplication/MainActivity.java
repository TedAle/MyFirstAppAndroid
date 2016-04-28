package com.example.ted.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ted.myapplication.model.Tank;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String LOG_TAG = "RecyclerViewActivity";

    public ArrayList<DataObject> datas = new ArrayList<DataObject>();
    public static ArrayList<Tank> tanks = new ArrayList<Tank>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        tanks = (ArrayList<Tank>) intent.getExtras().get(EXTRA_MESSAGE);
        datas = DataObjectContainer.getDatas(tanks);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        //TODO to check
//        RecyclerView.ItemDecoration itemDecoration =
//                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra(EXTRA_MESSAGE, ""+position);
                startActivity(intent);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
    /*    ArrayList<DataObject> results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    */
        if (datas==null){
            DataObjectContainer.getDatas(tanks);
        }
        return datas;
    }

//    public void clickIcon(View view) {
//        Intent intent = new Intent(this, ScrollingActivity.class);
//        intent.putExtra(EXTRA_MESSAGE, (String) view.getTag());
//        startActivity(intent);
//    }
}
