package com.btb.briefcaseservice.exception;

public enum BriefcaseErrorCodes implements ErrorCode {
    BRIEFCASE_ID_NOT_NULL(1, "briefcase.id.not.null"),
    BRIEFCASE_NOT_FOUND(2, "briefcase.not.found");

    private final int code;
    private final String message;

    BriefcaseErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getKey() {
        return null;
    }
}
