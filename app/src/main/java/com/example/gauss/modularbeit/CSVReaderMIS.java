package com.example.gauss.modularbeit;


import android.app.Activity;
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
import java.util.Locale;

/**
 * This class holds the static method CSVReaderMISRead which transforms the CSV files in the object list Meshes and Errors
 */
public class CSVReaderMIS {

    private static List<String[]> rows;
    private static Date startDate;
    private static Date endDate;
    private static Date errorOccurrenceDate;
    private static Date errorSolvedDate;
    private static Long productionTimeInS;
    private static Long errorSolvedTimeInS;

    /**
     * This method reads the CSV File coming from the csvStream and puts the content in the Meshes and Errors list
     * @param csvStream is a Inputstream with the CSV File
     */
    public static void CSVReaderMISRead(InputStream csvStream) {

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file
            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
            startDate = new Date();
            endDate = new Date();
            productionTimeInS = 0L;

            rows = csvReader.readAll();

            int i = 0;

            while (!isRowLastRow(i)) {       //We need the index to have access to the next line; the beginning of the next line is the end of the given line
                if (rows.get(i).length > 2) {              //Be sure that the row has at least two columns, the second colum indicates the row type
                    // Logic to fill the Meshes List, including the Parameter for each mesh
                    productionTimeInS = 0L;
                    if (isRowProduction(i)) {
                        String meshID = rows.get(i)[5];
                        setStartDate(i);
                        i++;
                        if (!isRowProduction(i)){
                            do {
                                //Search for line with a stop or error to stop production timer
                                if (isRowError(i) || isRowStop(i)) {
                                    setEndDate(i);
                                    long productionTimeInSTemp = productionTimeInS;
                                    calculateProductionTime();
                                    productionTimeInS += productionTimeInSTemp;
                                    int j = 0;
                                    //Search for a restart of the production
                                    do {
                                        j++;
                                    }
                                    while (!(isRowProduction(i + j) || isRowInOperation(i + j) || isRowLastRow(i + j)));
                                    i = i + j;
                                    if (isRowInOperation(i)){
                                        setStartDate(i);
                                    }
                                }
                                else {
                                    i++;
                                }
                            }
                            //repeat until the next mesh starts
                            while (!(isRowProduction(i) || isRowLastRow(i)));
                        }
                        if (!isRowLastRow(i)) {
                            setEndDate(i);
                            long productionTimeInSTemp = productionTimeInS;
                            calculateProductionTime();
                            productionTimeInS += productionTimeInSTemp;
                            Mesh meshRead = new Mesh(meshID, startDate, productionTimeInS);
                            Meshes.instance().add(meshRead);
                        }
                    }
                    else{
                        i++;
                    }
                }
            }
            i = 0;
            while (!isRowLastRow(i)) {       //We need the index to have access to the next line; the beginning of the next line is the end of the given line
                if(rows.get(i).length >2){              //Be sure that the row has at least two columns, the second colum indicates the row type
                    //If the machine was stopped skip the following error messages until the machine is in operation again
                    if (isRowStop(i)) {
                        int j = 0;
                        do {
                            j++;
                        }
                        while (!(isRowProduction(i + j) || isRowInOperation(i + j) || isRowLastRow(i + j)));
                        i = i + j;
                    }
                    // Logic to fill the Error List, including the Parameter for each error
                    else if (isRowError(i)) {   //take only lines with an error number
                        int errorNumber = Integer.parseInt(rows.get(i)[6]);
                        String errorMessage = rows.get(i)[4];
                        int errorInModuleId =Integer.parseInt(rows.get(i)[9]);
                        setErrorOccurrenceDate(i);
                        int j = 0;      //search for machine in operation again, make sure that the search end at the end of the file
                        do{
                            j++;
                        }
                        while (!(isRowInOperation(i + j) || isRowProduction(i + j) || isRowLastRow(i + j)));
                            if (!isRowLastRow(i+j)) {
                                setErrorSovedDate(i + j);
                                calculateErrorTime();
                                Error errorRead = new Error(errorNumber, errorMessage, errorInModuleId, "", errorOccurrenceDate, errorSolvedTimeInS);
                                Errors.instance().add(errorRead);
                            }
                            i = i + j;
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

    private static void setStartDate(int startDateRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
        try {
            startDate = simpleDateFormat.parse(rows.get(startDateRowNumber)[0] + " " + rows.get(startDateRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void setEndDate(int endDateRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
        try {
            endDate = simpleDateFormat.parse(rows.get(endDateRowNumber)[0] + " " + rows.get(endDateRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void setErrorOccurrenceDate(int errorOccuranceRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
        try {
            errorOccurrenceDate = simpleDateFormat.parse(rows.get(errorOccuranceRowNumber)[0] + " " + rows.get(errorOccuranceRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void setErrorSovedDate(int errorSovedRowNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
        try {
            errorSolvedDate = simpleDateFormat.parse(rows.get(errorSovedRowNumber)[0] + " " + rows.get(errorSovedRowNumber)[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    private  static boolean isRowLastRow(int rowNumber) {
        return rowNumber >= rows.size()-1;
    }

    private  static boolean isRowInOperation(int rowNumber) {
        return rows.get(rowNumber)[2].equals(("S")) && (rows.get(rowNumber)[6].equals("3") || rows.get(rowNumber)[6].equals("2051"));
    }

    private  static boolean isRowError(int rowNumber) {
        return rows.get(rowNumber)[2].equals("E") && !rows.get(rowNumber)[6].equals("0") && rows.get(rowNumber)[3].equals("Automat") && rows.get(rowNumber)[8].equals("0");
    }

    private  static boolean isRowProduction(int rowNumber) {
        return rows.get(rowNumber)[2].equals("P") &&  rows.get(rowNumber)[3].equals("Automat");
    }

    private  static boolean isRowStop(int rowNumber) {
        return rows.get(rowNumber)[4].equals("Stopped");
    }

    private static void calculateProductionTime() {
        productionTimeInS = (endDate.getTime() - startDate.getTime()) / 1000;
    }

    private static void calculateErrorTime() {
        errorSolvedTimeInS = (errorSolvedDate.getTime() - errorOccurrenceDate.getTime()) / 1000;
    }
}
