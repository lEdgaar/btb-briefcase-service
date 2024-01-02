package com.btb.briefcaseservice.exception;

public class BriefcaseException extends CommonApiException {
    public BriefcaseException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
