package com.example.gauss.modularbeit;

import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Unit test Class to test the transformation of the csv production file into the Meshes list
 */
public class UnitTestFileReaderProduction {

    /**
     * Unit test to test the reading of the Mesh from csv File into the Meshes list. The last line of the file is a Mesh     */
    @Test
    public void CSVReaderMISTestProductionLast() throws Exception{

        Meshes.instance();
        Errors.instance();

        InputStream csvStream = getClass().getClassLoader().getResourceAsStream("MISEvents.10000.DEU.Test.Production.Last.csv");
        CSVReaderMIS.CSVReaderMISRead(csvStream);
        assertEquals(31L,(long) Meshes.instance().getMesh(0).getProductionTimeInS()); //first Mesh
        assertEquals(30L,(long) Meshes.instance().getMesh(5).getProductionTimeInS()); //last Mesh
        assertEquals("SC 45  SIK  3LU", Meshes.instance().getMesh(0).getMeshId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
        assertEquals( simpleDateFormat.parse("19.03.2012 07:59:31"),Meshes.instance().getMesh(0).getProductionStart());
    }

}

