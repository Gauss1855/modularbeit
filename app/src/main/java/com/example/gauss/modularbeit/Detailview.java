package com.example.gauss.modularbeit;

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

        int i = 0;
        List<Error> error = Errors.instance().getErrormessages();
        Error test = error.get(i);
        String modulId = "Module Id:" + test.getErrorInModuleId();

        TextView listView = (TextView) findViewById(R.id.textView2);
        listView.setText(modulId);





        //werte.add(titel);
       /* for(Error error : Errors.instance().getErrormessages()){
            String errorMessage = error.getErrorMessage();
            String inModuldId = Integer.toString(error.getErrorInModuleId());


            //String[] id = error.getErrorNumber(); + "        " +  "       " + error.getErrorMessage();

            ;
            //werte.add(error.getErrorMessage());
            i++;
        }*/





        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Detailview.this.getBaseContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, werte);
        listView.setAdapter(adapter);*/
    }

}
