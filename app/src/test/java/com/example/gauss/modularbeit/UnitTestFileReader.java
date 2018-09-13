package com.example.gauss.modularbeit;

import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class UnitTestFileReader {

        @Test
        public void CSVReaderMISTest() throws Exception{

            Meshes.instance();
            Errors.instance();

            InputStream csvStream = getClass().getClassLoader().getResourceAsStream("MISEvents.10000.DEU.Test.Production.csv");
            CSVReaderMIS.CSVReaderMISRead(csvStream);


                assertEquals(31L,(long) Meshes.instance().get(1).getProductionTimeInS());


        }
}

