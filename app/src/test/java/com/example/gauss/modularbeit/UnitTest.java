package com.example.gauss.modularbeit;

import android.app.Application;
import android.content.Context;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class UnitTest {
    @Test
    public void CSVReaderMISTest(){

        Context ctx = new Application();

        Meshes.instance();
        Errors.instance();

        String fileNameMIS = "MISEvents.10000.DEU.Test.Production.csv";
        String fileNameZG = "zgs.DEU.txt";

        CSVReaderMIS.CSVReaderMISRead(ctx, fileNameMIS);

        int k = 0;

        for(Mesh mesh: Meshes.instance().getMeshes()){
            k++;
            assertEquals(10L,(long) mesh.getProductionTimeInS());
        }

    }
}