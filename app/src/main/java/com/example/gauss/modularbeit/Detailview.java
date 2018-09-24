package com.example.gauss.modularbeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Set the Detailansicht with an ArrayList who includes all necessary informations about the Alerts.
 */

public class Detailview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Detailansicht");


        Bundle secondIntent = getIntent().getExtras();
        int i = secondIntent.getInt("MY_POSITION");

        List<Error> errorList = Errors.instance().getErrors();

        Error error = errorList.get(i);
        String errorNr = Integer.toString(error.getErrorNumber());
        String errorMessage = error.getErrorMessage();
        String modulId =  Integer.toString(error.getErrorInModuleId());
        String modulText = error.getErrorInModuleText();
        Date date = error.getErrorOccurrence();
        String occurrence = date.toString();
        String solve = Long.toString(error.getErrorSolveTimeInS());

        TextView textErrorNr = (TextView) findViewById(R.id.textErrorNr);
        TextView textErrorMessage = (TextView) findViewById(R.id.textErrorMessage);
        TextView textModulId = (TextView) findViewById(R.id.textModulID);
        TextView textOccurrence = (TextView) findViewById(R.id.textOc);
        TextView textSolve = (TextView) findViewById(R.id.textSolve);

        textErrorNr.setText(errorNr);
        textErrorMessage.setText(errorMessage);
        textModulId.setText(modulId);
        textOccurrence.setText(occurrence);
        textSolve.setText(solve);



    }

}
