package com.coding.spring_rest_crud.dto;

public class StudentErrorResponse {

    private int status = 500;
    private String message = "Error";
    private long timeStamp;

    public StudentErrorResponse() {

    }

    public StudentErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
