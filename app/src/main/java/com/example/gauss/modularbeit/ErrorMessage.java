package com.example.gauss.modularbeit;

import java.util.Date;

public class ErrorMessage {
    private Integer errorNumber;
    private String errorMessage;
    private Integer errorInModuleId;
    private Date errorOccurance;
    private long errorSolveTimeInS;

    public ErrorMessage(Integer errorNumber, String errorMessage, Integer errorInModuleId, Date errorOccurance, Long timeSolveErrorInS) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.errorInModuleId = errorInModuleId;
        this.errorOccurance = errorOccurance;
        this.errorSolveTimeInS = timeSolveErrorInS;
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

    public Long getErrorSolveTimeInS() {
        return getErrorSolveTimeInS();
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

    public void setErrorSolveTimeInS(Long errorSolveTimeInS) {this.errorSolveTimeInS = errorSolveTimeInS;
    }

}
