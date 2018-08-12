package com.example.gauss.modularbeit;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages{
    private List<ErrorMessage> errorMessages;

    public ErrorMessages(){
        errorMessages = new ArrayList<>();
    }

    public List<ErrorMessage> getErrormessages() {
        return errorMessages;
    }

    public boolean add(ErrorMessage errorMessage) {
        errorMessages.add(errorMessage);
        return true;
    }

    public int size() {
        return errorMessages.size();
    }

    public ErrorMessage get(int i) {
        return errorMessages.get(i);
    }
}
