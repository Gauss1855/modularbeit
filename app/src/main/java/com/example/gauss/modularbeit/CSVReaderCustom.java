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

    public static void CSVParser(Context ctx) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("mis.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');

            List<String[]> rows = csvReader.readAll();

            for (String[] row : rows) {
                for (String value :row){
                    Log.e("test", value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
