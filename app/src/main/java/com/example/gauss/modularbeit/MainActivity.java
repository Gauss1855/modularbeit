package com.example.gauss.modularbeit;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   // public static final boolean DEFAULT_KEEP_CR= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context ctx = getApplicationContext();

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        Meshes.instance();
        Errors.instance();


        CSVReaderMIS.CSVReaderMISRead(ctx);

        int k = 0; //Testausgabe Produktionszeiten
        for(Mesh mesh: Meshes.instance().getMeshes()){
            k++;
            if ( mesh.getProductionTimeInS() < 10 ){
                Log.i("test","Produktionszeit Gitter: " + k + " "+ mesh.getProductionTimeInS() + "                                        " + mesh.getProductionStart());
            }
            else if (mesh.getProductionTimeInS() > 50){
                Log.i("test","Produktionszeit Gitter: " + k + " "+ mesh.getProductionTimeInS() + "                                        " + mesh.getProductionStart());
            }
        }

        int l = 0; //Testausgabe Stillstandszeiten
        for(Error error : Errors.instance().getErrormessages()){
            l++;
            Log.i("test","Fehlerbehandlungszeit: " + l + " " + error.getErrorSolveTimeInS() + "                                      " + error.getErrorOccurance());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    //Das ist ein Test blub
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, Alertview.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, Productionview.class);
                startActivity(intent2);
                this.finish();
                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, Helpview.class);
                startActivity(intent3);
                this.finish();
                break;
        }
    }
}
