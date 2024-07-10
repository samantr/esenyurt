package com.esenyurt.enums;

public enum ErrorMessages {

    TRANSACTION_FAILED("1","transaction failed"),
    RECORD_NOT_FOUND("2","record not found"),

    OBJECT_ALREADY_EXISTS("3","Object already exists")
    ;


    private String value;
    private String title;

    ErrorMessages(String value, String title) {
        this.value = value;
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
