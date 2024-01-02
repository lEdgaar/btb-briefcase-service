package com.btb.briefcaseservice.exception;

public class AssetsException extends CommonApiException{
    public AssetsException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
