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

public class Alertview extends AppCompatActivity {
    ListView listView;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        listView = (ListView) findViewById(R.id.alert_list);


        ArrayList<String> werte = new ArrayList<>();

        for(Error error : Errors.instance().getErrormessages()){

            werte.add(error.getErrorMessage());

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Alertview.this.getBaseContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, werte);
        listView.setAdapter(adapter);


        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Intent appInfo = new Intent(Alertview.this, Detailview.class);
                //String itemValue = (String) listView.getItemAtPosition(position).toString();
                //int itemValue = Integer.toString(position);
                appInfo.putExtra("MY_POSITION", position);
                startActivity(appInfo);
            }

        });

    }

}


