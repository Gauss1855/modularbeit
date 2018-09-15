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
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Productionview extends AppCompatActivity {

    //ListView listView;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> meshGroup = Arrays.asList("Group1", "Group2");
    List<String> meshItem = Arrays.asList("Item1", "Item2");
    //Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productionview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Ansicht Produktionsdaten");

        expListView = (ExpandableListView) findViewById(R.id.production_list);

        listAdapter = new ExpandableListAdapter(this, meshGroup, meshItem);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        meshGroup.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        meshItem.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



 /*       listView = (ListView) findViewById(R.id.production_list);


        ArrayList<String> werte = new ArrayList<>();
       // ArrayList<String> wertezwei = new ArrayList<>();

       // int i = 0;
        //String eins = "1";
        for(Mesh mesh : Meshes.instance().getMeshes()){
            String test = mesh.getMeshId() + "  |  " + mesh.getProductionStart();
            werte.add(test);
        }

        //for(String test : werte){

          // if(test.equals("1")) {
           // wertezwei.add(test);
         //  }
      // } ;



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Productionview.this.getBaseContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,Meshes.instance().getMeshesAsStings());
        listView.setAdapter(adapter);


        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Intent appInfo = new Intent(Productionview.this, Detailviewproduction.class);
                //String itemValue = (String) listView.getItemAtPosition(position).toString();
                //int itemValue = Integer.toString(position);
                appInfo.putExtra("MY_POSITION", position);
                startActivity(appInfo);
            }

        });*/
    }

}
