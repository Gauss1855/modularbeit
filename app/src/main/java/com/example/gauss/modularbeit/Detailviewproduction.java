package com.example.gauss.modularbeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Detailviewproduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailviewproduction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Detailansicht");

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

        List<Mesh> meshList = Meshes.instance().getMeshes();


        Mesh mesh = meshList.get(i);

        String meshId = mesh.getMeshId();
        Date startTime = mesh.getProductionStart();
        Date endTime = new Date();
        long time = startTime.getTime()/1000;
        time = (time + mesh.getProductionTimeInS())*1000;
        endTime.setTime(time);

        String pStart = startTime.toString();
        String pEnde = endTime.toString();
        String pTime = Long.toString(mesh.getProductionTimeInS())  + "  " + "Sekunden";

        TextView textmeshId = (TextView) findViewById(R.id.textMeshId);
        TextView textPstart = (TextView) findViewById(R.id.textProduktionStart);
        TextView textPtime = (TextView) findViewById(R.id.textProductionTime);
        TextView textEtime = (TextView) findViewById(R.id.textProductionEndTime);

        textmeshId.setText(meshId);
        textPstart.setText(pStart);
        textPtime.setText(pTime);
        textEtime.setText(pEnde);
    }

}
