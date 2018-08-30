package com.example.gauss.modularbeit;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TxtReaderZGTexte {
    private Context ctx;

    public TxtReaderZGTexte(Context ctx, ErrorMessages errorMessages) {

        AssetManager assetManager = ctx.getAssets();

        try {
            InputStream csvStream = assetManager.open("zgs.ENG.txt");
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream,"UTF-16LE");        // Hex FE at the beginning of the file stands for "UTF16-LE" fomated file
            BufferedReader reader = new BufferedReader(csvStreamReader);
            String zeile = reader.readLine();
            while (zeile != null) {
                zeile = reader.readLine();
                Log.e("test",zeile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
