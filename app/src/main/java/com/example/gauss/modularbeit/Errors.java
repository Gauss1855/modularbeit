package com.example.gauss.modularbeit;

import java.util.ArrayList;
import java.util.List;

/**
 * Errors holds a list with Error, the pattern is a Singleton
 */

public class Errors {
    private List<Error> errors;
    private static Errors instance = null;

    public static Errors instance() {
        if (instance == null)
            instance = new Errors();

        return instance;
    }

    protected Errors(){
        errors = new ArrayList<>();
    }

    public List<Error> getErrors() {
        return errors;
    }

    public boolean add(Error error) {
        errors.add(error);
        return true;
    }

    public int size() {
        return errors.size();
    }

    public Error getError(int i) {
        return errors.get(i);
    }
}
