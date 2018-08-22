package com.example.gauss.modularbeit;

import android.content.Context;
import android.content.res.AssetManager;

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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
