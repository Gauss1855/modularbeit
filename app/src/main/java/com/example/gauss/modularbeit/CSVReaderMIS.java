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

    private  Context ctx;
    private  String[] line;
    //public  final boolean DEFAULT_KEEP_CR = true;
    private List<String[]> rows;
    private Date startDate;
    private Date endDate;
    private Date errorOccuranceDate;
    private Date errorSolvedDate;
    private Long productionTimeInS;

    public CSVReaderMIS(Context ctx, Meshes meshes, ErrorMessages errorMessages) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("MIS.10000.csv");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            startDate = new Date();
            endDate = new Date();
            productionTimeInS = 0L;

            rows = csvReader.readAll();

            int i = 0;

            while (!isRowLastRow(i)) {       //We need the index to have access to the next line; the beginning of the next line is the end of the given line
                if(rows.get(i).length >2){              //Be sure that the row has at least two columns, the second colum indicates the row type
                    // Logic to fill the Meshes List, including the Parameter for each mesh
                    if(isRowProduction(i)) {
                        String meshID = rows.get(i)[5];
                        setStartDate(i);
                        if (isRowProduction(i + 1)){
                            setEndDate(i + 1);
                            calculateProductionTime(startDate, endDate);
                        }
                        else {
                            do {
                                if (isRowError(i + 1)) {
                                    setEndDate(i + 1);
                                    long productionTimeInSTemp = productionTimeInS;
                                    calculateProductionTime(startDate, endDate);
                                    productionTimeInS += productionTimeInSTemp;
                                    int j = 0;
                                    do {
                                        j++;
                                    }
                                    while (!(isRowProduction(i + j) || isRowInOperation(i + j)) && isRowLastRow(i + j));
                                    i = i + j;
                                    setStartDate(i);
                                } else {
                                    int j = 0;
                                    do {
                                        j++;
                                    }
                                    while (!(isRowProduction(i + j) || isRowInOperation(i + j))&& isRowError(i + j));
                                    i = i + j;
                                    setStartDate(i);
                                }
                            }
                            while (!(isRowProduction(i) || isRowLastRow(i))) ;
                        }
                        if (!isRowLastRow(i)){
                            Mesh meshRead = new Mesh(meshID, startDate, productionTimeInS);
                            meshes.add(meshRead);
                            i++;
                        }
                    }
                    // Logic to fill the Error List, including the Parameter for each error
                    else if(isRowError(i)) {   //take only lines with an error number
                        int errorNumber = Integer.parseInt(rows.get(i)[6]);
                        String errorMessage = rows.get(i)[4];
                        int errorInModuleId =Integer.parseInt(rows.get(i)[9]);
                        setErrorOccuranceDate(i);
                        int j = 0;      //search for machine in operation again, make sure that the search end at the end of the file
                        do{
                            j++;
                        }
                        while (!(isRowInOperation(i + j) || isRowProduction(i + j)) || isRowLastRow(i + j));
                        setErrorSovedDate(i + j);
                        ErrorMessage errorRead = new ErrorMessage(errorNumber,errorMessage,errorInModuleId,errorOccuranceDate,errorSolvedDate);
                        errorMessages.add(errorRead);
                        i = i +j;
                    }
                    else if(isRowStop(i)){
                        setEndDate(i);
                        calculateProductionTime(startDate, endDate);
                        i++;
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

    public void setStartDate(int startDateRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            this.startDate = simpleDateFormat.parse(rows.get(startDateRowNumber)[0] + " " + rows.get(startDateRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setEndDate(int endDateRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            this.endDate = simpleDateFormat.parse(rows.get(endDateRowNumber)[0] + " " + rows.get(endDateRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setErrorOccuranceDate(int errorOccuranceRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            this.errorOccuranceDate = simpleDateFormat.parse(rows.get(errorOccuranceRowNumber)[0] + " " + rows.get(errorOccuranceRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setErrorSovedDate(int errorSovedRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            this.errorSolvedDate = simpleDateFormat.parse(rows.get(errorSovedRowNumber)[0] + " " + rows.get(errorSovedRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    private  boolean isRowLastRow(int rowNumber) {
        return rowNumber >= rows.size()-1;
    }

    private  boolean isRowInOperation(int rowNumber) {
        return rows.get(rowNumber)[2].equals(("S")) && rows.get(rowNumber)[6].equals("2051");
    }

    private  boolean isRowError(int rowNumber) {
        return rows.get(rowNumber)[2].equals("E") && !rows.get(rowNumber)[6].equals("0");
    }

    private  boolean isRowProduction(int rowNumber) {
        return rows.get(rowNumber)[2].equals("P");
    }

    private  boolean isRowStop(int rowNumber) {
        return rows.get(rowNumber)[2].equals("S") && rows.get(rowNumber)[6].equals("8211");
    }

    public void calculateProductionTime(Date startDate, Date endDate) {
        this.productionTimeInS = (endDate.getTime() - startDate.getTime()) / 1000;
    }
}
