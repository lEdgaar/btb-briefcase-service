package com.btb.briefcaseservice.md;

public enum TransactionTypeMD {
    BUY(1),
    SELL(0);

    private int code;

     TransactionTypeMD(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
