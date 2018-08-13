package com.example.gauss.modularbeit;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.WeakHashMap;

public class CSVReaderMIS {

    private static Context ctx;
    private static String[] line;
    public static final boolean DEFAULT_KEEP_CR = true;

    public static void CSVParser(Context ctx, Meshes meshes, ErrorMessages errorMessages) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("MIS.10000_Test.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            List<String[]> rows = csvReader.readAll();

            int i = 0;

            while (i < rows.size()) {       //We need the index to have access to the next line; the beginning of the next line is the end of the given line
                if(rows.get(i).length >2){              //Be sure that the row has at least two columns, the second colum indicates the row type
                    // Logic to fill the Meshes List, including the Parameter for each mesh
                    if(rows.get(i)[2].equals("P")) {
                        Date startDate = new Date();
                        Date endDate = new Date();
                        Long productionTiemInS = 0L;

                        try {
                            String meshID = rows.get(i)[5];
                            do {
                                int j = 0;
                                startDate = simpleDateFormat.parse(rows.get(i)[0] + " " + rows.get(i)[1]);
                                do {
                                    j++;
                                }
                                while (!(rows.get(i + j)[6].equals("2051") || (rows.get(i + j)[2].equals("P"))) && i + j + 1 < rows.size());
                                if (i + j +1 < rows.size()) {
                                    endDate = simpleDateFormat.parse(rows.get(i + j)[0] + " " + rows.get(i + j)[1]);
                                    productionTiemInS = productionTiemInS + (endDate.getTime() - startDate.getTime()) / 1000;
                                }
                                i = i + j;
                            }
                            while (!rows.get(i)[2].equals("P") && i + 1 < rows.size());
                            if (i + 1 < rows.size()){
                                Mesh meshRead = new Mesh(meshID, startDate, productionTiemInS);
                                meshes.add(meshRead);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    // Logic to fill the Error List, including the Parameter for each error
                    else if(rows.get(i)[2].equals("E") && !rows.get(i)[6].equals("0")){   //take only lines with an error number
                        try {
                            int errorNumber = Integer.parseInt(rows.get(i)[6]);
                            String errorMessage = rows.get(i)[4];
                            int errorInModuleId =Integer.parseInt(rows.get(i)[9]);
                            Date errorOccurance =  simpleDateFormat.parse(rows.get(i)[0] + " " +rows.get(i)[1]);
                            int j = 0;      //search for machine in operation again, make sure that the search end at the end of the file
                            do{
                                j++;
                            }
                            while (!(rows.get(i + j)[2].equals("S") && rows.get(i + j)[6].equals("2051")) && i + j + 1 < rows.size());
                            Date errorSolved = simpleDateFormat.parse(rows.get(i+j)[0]+ " " +rows.get(i+j)[1]);
                            ErrorMessage errorRead = new ErrorMessage(errorNumber,errorMessage,errorInModuleId,errorOccurance,errorSolved);
                            errorMessages.add(errorRead);
                            i = i +j;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        i++;
                    }
                 }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
