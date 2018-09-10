package com.example.gauss.modularbeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Alertview extends AppCompatActivity {

    List<Error> errors = Errors.instance().getErrormessages();
    //Error test = errors.get(7);


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

        ListView listView = (ListView) findViewById(R.id.alert_list);

        ArrayList<String> blub = new ArrayList<String>();

        //blub.add(test.getErrorMessage());


       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(
       //         Alertview.this.getBaseContext(),
       //         android.R.layout.simple_list_item_1, android.R.id.text1, blub);
       // listView.setAdapter(adapter);


        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), errors);
        listView.setAdapter(adapter);
    }

}
