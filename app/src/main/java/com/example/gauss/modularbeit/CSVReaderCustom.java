package com.example.gauss.modularbeit;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CSVReaderCustom {

    private static String[] line;

    public static void CSVParser(Context ctx) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("mis.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');

//            // setup the alert builder
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("My title");
//            builder.setMessage(line[0]);
//
//            // add a button
//            builder.setPositiveButton("OK", null);
//
//            // create and show the alert dialog
//            AlertDialog dialog = builder.create();
//            dialog.show();

            //while ((line = csvReader.readNext()) != null) {
            for (int i = 0; i<10 ;i++){

                line = csvReader.readNext();

                for (String value : line) {
                    Log.e("test", value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
