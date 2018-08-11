package com.example.gauss.modularbeit;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVReaderMIS {

    private static String[] line;
    public static final boolean DEFAULT_KEEP_CR = true;

    public static void CSVParser(Context ctx, Meshes meshes, ErrorMessages errorMessages) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("mis.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            List<String[]> rows = csvReader.readAll();

            for (int i=0; i < rows.size(); i++) {       //We need the index to have access to the next line; the beginning of the next line is the end of the given line
                if(rows.get(i).length >2){              //Be sure that the row has at least two columns, the second colum indicates the row type
                    // Logic to fill the Meshes List, including the Parameter for each mesh
                    if(rows.get(i)[2].equals("P")){
                        try {
                            String meshID = new String(rows.get(i)[5]);
                            Date startDate =  simpleDateFormat.parse(rows.get(i)[0] + " " +rows.get(i)[1]);
                            int j = 0;      //search for the next production line
                            do{
                                j++;
                            }
                            while (!rows.get(i + j)[2].equals("P") && i + j + 1 < rows.size());
                            Date endDate = simpleDateFormat.parse(rows.get(i+j)[0]+ " " +rows.get(i+j)[1]);
                            Mesh meshRead = new Mesh(meshID,startDate,endDate);
                            meshes.add(meshRead);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
