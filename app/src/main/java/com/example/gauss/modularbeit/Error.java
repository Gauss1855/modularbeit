package com.example.gauss.modularbeit;

import java.util.Date;

/**
 * The Error is a failure of the machine functionality. The attributes describe the type of failure and the correction time needed. It bears also the module of the machine where the error did occure
 */
public class Error {
    private Integer errorNumber;
    private String errorMessage;
    private Integer errorInModuleId;
    private String errorInModuleText;
    private Date errorOccurrence;
    private long errorSolveTimeInS;

    protected Error(Integer errorNumber, String errorMessage, Integer errorInModuleId, String errorInModuleText, Date errorOccurrence, Long errorSolveTimeInS) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.errorInModuleId = errorInModuleId;
        this.errorInModuleText = errorInModuleText;
        this.errorOccurrence = errorOccurrence;
        this.errorSolveTimeInS = errorSolveTimeInS;
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

    public String getErrorInModuleText() {return errorInModuleText; }

    public Date getErrorOccurrence() {
        return errorOccurrence;
    }

    public Long getErrorSolveTimeInS() {
        return errorSolveTimeInS;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorNumber(Integer errorNumber) {
        this.errorNumber = errorNumber;
    }

    public void setErrorInModuleId(Integer errorInModuleId) {this.errorInModuleId = errorInModuleId;}

    public void setErrorInModuleText(String errorInModuleText) {this.errorInModuleText = errorInModuleText;}

    public void setErrorOccurrence(Date errorOccurance) {
        this.errorOccurrence = errorOccurance;
    }

    public void setErrorSolveTimeInS(Long errorSolveTimeInS) {this.errorSolveTimeInS = errorSolveTimeInS;
    }

}
