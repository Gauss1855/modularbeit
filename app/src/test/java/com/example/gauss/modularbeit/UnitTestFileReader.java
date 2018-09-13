package com.example.gauss.modularbeit;

import android.app.Application;
import android.content.Context;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class UnitTestFileReader {
    @Test
    public void CSVReaderMISTest() throws Exception{


        InputStream csvStream = getClass().getClassLoader().getResourceAsStream("MISEvents.10000.DEU.Test.Production.csv");
        InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file

        com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(csvStreamReader, '\t');

        Meshes.instance();
        Errors.instance();

        int k = 0;

        for(Mesh mesh: Meshes.instance().getMeshes()){
            k++;
            assertEquals(10L,(long) mesh.getProductionTimeInS());
        }

    }
}