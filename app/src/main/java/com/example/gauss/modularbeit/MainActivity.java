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

public class MainActivity extends AppCompatActivity {

   // public static final boolean DEFAULT_KEEP_CR= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context ctx = getApplicationContext();

        Meshes.instance();
        ErrorMessages.instance();

        CSVReaderMIS csvReaderMIS= new CSVReaderMIS(ctx);
        //TxtReaderZGTexte txtReaderZGTexte = new TxtReaderZGTexte(ctx, errorMessages);

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
        for(ErrorMessage errorMessage: ErrorMessages.instance().getErrormessages()){
            l++;
            Log.i("test","Fehlerbehandlungszeit: " + l + " " + errorMessage.getErrorSolveTimeInS() + "                                      " + errorMessage.getErrorOccurance());
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
}
