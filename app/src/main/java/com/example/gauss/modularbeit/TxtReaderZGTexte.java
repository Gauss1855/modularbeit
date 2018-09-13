package com.example.gauss.modularbeit;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;

/**
 * This class holds the static method TxtReaderZGTexteRead which adds the module description texts to the Errors
 */
public class TxtReaderZGTexte {

    /**
     * This method reads the txt File coming from the txtStream and add the module description to the Errors
     * @param txtStream is a Inputstream with the txt File
     */
    public static void TxtReaderZGTexteRead(InputStream txtStream) {

        List<String> zgTexts = new ArrayList<>();

        //Reading the file with the descriptions of the modules in the list zgTexts
        try {
            InputStreamReader txtStreamReader = new InputStreamReader(txtStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file
            BufferedReader reader = new BufferedReader(txtStreamReader);
            String line = reader.readLine();
            while (line != null) {
                zgTexts.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Set the error message text according to the text in the zgs.txt
        for(Error error : Errors.instance().getErrormessages()){
            for(String zgLine : zgTexts){
                int textPosition = zgLine.indexOf("#" + Integer.toString(error.getErrorInModuleId()));
                if (textPosition != -1){
                    String[] zgLineParts = zgLine.split("]");
                    error.setErrorInModuleText(trim(zgLineParts[1]));
                }

            }

        }

    }

}
