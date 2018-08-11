package com.example.gauss.modularbeit;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CSVReaderCustom {

    private static String[] line;
    public static final boolean DEFAULT_KEEP_CR = true;

    public static void CSVParser(Context ctx) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("mis.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');

            List<String[]> rows = csvReader.readAll();

            for (String[] row : rows) {
                Log.d("test", "länge "+ row.length);
                if(row.length <= 2 & row[2]=="P"){
                    Log.e("Produktion Startzeit", row[1]);
                }
                for (String value :row){
                    Log.e("test", value);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
