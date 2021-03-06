package com.example.gauss.modularbeit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Create an View about the Alerts with an ArrayList.
 */

public class Alertview extends AppCompatActivity {
    ListView listView;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Ansicht Fehler-Meldungen");

        listView = (ListView) findViewById(R.id.alert_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Alertview.this.getBaseContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, Errors.instance().getErrorsAsStings());
        listView.setAdapter(adapter);


        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Intent appInfo = new Intent(Alertview.this, Detailview.class);
                appInfo.putExtra("MY_POSITION", position);
                startActivity(appInfo);
            }

        });

    }

}


