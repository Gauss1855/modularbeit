package com.example.gauss.modularbeit;

import java.util.Date;

public class ErrorMessage {
    private Integer errorNumber;
    private String errorMessage;
    private Integer errorInModuleId;
    private Date errorOccurance;
    private Date errorSolved;

    public ErrorMessage(Integer errorNumber, String errorMessage, Integer errorInModuleId, Date errorOccurance, Date errorSolved) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.errorInModuleId = errorInModuleId;
        this.errorOccurance = errorOccurance;
        this.errorSolved = errorSolved;
    }

    public Integer getErrorNumber() {
        return errorNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getErrorInModuleId() {
        return errorInModuleId;
    }

    public Date getErrorOccurance() {
        return errorOccurance;
    }

    public Date getErrorSolved() {
        return errorSolved;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorNumber(Integer errorNumber) {
        this.errorNumber = errorNumber;
    }

    public void setErrorInModuleId(Integer errorInModuleId) {
        this.errorInModuleId = errorInModuleId;
    }

    public void setErrorOccurance(Date errorOccurance) {
        this.errorOccurance = errorOccurance;
    }

    public void setErrorSolved(Date errorSolved) {
        this.errorSolved = errorSolved;
    }

    public long errorCorrectionTimeInS(){
        return (getErrorSolved().getTime() - getErrorOccurance().getTime()) / 1000;
    }
}
