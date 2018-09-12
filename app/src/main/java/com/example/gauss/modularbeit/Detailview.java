package com.example.gauss.modularbeit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Detailview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);
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


        Bundle secondIntent = getIntent().getExtras();
        int i = secondIntent.getInt("MY_POSITION");

        List<Error> errorList = Errors.instance().getErrormessages();

        Error error = errorList.get(i);
        String modulId = "Module Id:" + error.getErrorInModuleId();
        String errorNr = "Error Nummer:" + error.getErrorNumber();

        TextView textModulId = (TextView) findViewById(R.id.textView1);
        textModulId.setText(modulId);
        TextView textErrorNr = (TextView) findViewById(R.id.textView2);
        textErrorNr.setText(modulId);

    }

}
