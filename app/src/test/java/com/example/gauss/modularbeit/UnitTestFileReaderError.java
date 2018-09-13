package com.example.gauss.modularbeit;

import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class UnitTestFileReaderError {
    @Test
    public void CSVReaderMISTestErrorLast() throws Exception{

        Meshes.instance();
        Errors.instance();

        InputStream csvStream = getClass().getClassLoader().getResourceAsStream("MISEvents.10000.DEU.Test.Error.Last.csv");
        CSVReaderMIS.CSVReaderMISRead(csvStream);

        InputStream txtStream = getClass().getClassLoader().getResourceAsStream("zgs.ENG.txt");
        TxtReaderZGTexte.TxtReaderZGTexteRead(txtStream);

        assertEquals(47L,(long) Errors.instance().get(0).getErrorSolveTimeInS()); //first error
        assertEquals(9L,(long) Errors.instance().get(4).getErrorSolveTimeInS()); //last error
        assertEquals(1084,(int)Errors.instance().get(3).getErrorNumber());
        assertEquals("QF: 1084-0: Querdraht: Überwachung Nummer 2 von Einwurf Draht II ist nicht bereit. Handfunktion 0.31.x ist freigegeben. MG: Eingang E 69.4 muss <EIN> sein.", Errors.instance().get(3).getErrorMessage());
        assertEquals(1906, (int)Errors.instance().get(3).getErrorInModuleId());
        assertEquals("QF with intermediate station", Errors.instance().get(3).getErrorInModuleText());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
        assertEquals( simpleDateFormat.parse("19.03.2012 08:06:00"),Errors.instance().get(2).getErrorOccurrence());
    }
}
