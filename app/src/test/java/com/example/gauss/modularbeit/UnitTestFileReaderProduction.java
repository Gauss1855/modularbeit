package com.example.gauss.modularbeit;

import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class UnitTestFileReaderProduction {

        @Test
        public void CSVReaderMISTestProductionLast() throws Exception{

            Meshes.instance();
            Errors.instance();

            InputStream csvStream = getClass().getClassLoader().getResourceAsStream("MISEvents.10000.DEU.Test.Production.Last.csv");
            CSVReaderMIS.CSVReaderMISRead(csvStream);
            assertEquals(31L,(long) Meshes.instance().get(0).getProductionTimeInS()); //first Mesh
            assertEquals(30L,(long) Meshes.instance().get(5).getProductionTimeInS()); //last Mesh
            assertEquals("SC 45  SIK  3LU", Meshes.instance().get(0).getMeshId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
            assertEquals( simpleDateFormat.parse("19.03.2012 07:59:31"),Meshes.instance().get(0).getProductionStart());
        }

}

