package com.btb.briefcaseservice.exception;

public class DBException extends CommonApiException {


    public DBException(String message) {
        super(ControlErrorCodes.DB, message);
    }
}
