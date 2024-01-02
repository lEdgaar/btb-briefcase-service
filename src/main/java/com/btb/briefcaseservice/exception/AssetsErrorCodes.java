package com.btb.briefcaseservice.exception;

public enum AssetsErrorCodes implements ErrorCode {
    ASSET_ID_NOT_NULL(1, "asset.id.not.null"),
    ASSET_NOT_FOUND(2, "asset.not.found");

    private final int code;
    private final String message;

    AssetsErrorCodes(int code, String message) {
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
