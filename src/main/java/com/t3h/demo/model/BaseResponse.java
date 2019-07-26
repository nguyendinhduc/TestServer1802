package com.t3h.demo.model;

public class BaseResponse {
    private int status;
    private String message;
    private Object data;

    private BaseResponse(){

    }
    public static BaseResponse createResponse(
            int status, String message
    ){
        BaseResponse response = new BaseResponse();
        response.status =status;
        response.message = message;
        return response;
    }
    public static BaseResponse createResponse(
            Object data
    ){
        BaseResponse response = new BaseResponse();
        response.data = data;
        response.status =1;
        response.message = "SUCCESS";
        return response;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
