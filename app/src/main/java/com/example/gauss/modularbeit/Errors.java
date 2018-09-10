package com.example.gauss.modularbeit;

import java.util.ArrayList;
import java.util.List;

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

    public List<Error> getErrormessages() {
        return errors;
    }

    public boolean add(Error error) {
        errors.add(error);
        return true;
    }

    public int size() {
        return errors.size();
    }

    public Error get(int i) {
        return errors.get(i);
    }
}