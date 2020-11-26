package com.system.translation.util;

import java.io.Serializable;

/**
 * @author Andon
 * 2020/11/26
 */
public class StandardResponse implements Serializable {

    private boolean success;
    private String code;
    private String message;
    private Object data;
    private long total;

    public StandardResponse() {
    }

    public StandardResponse(boolean success, String code, String message, Object data, long total) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public static StandardResponse successStandardResponse() {
        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setSuccess(true);
        standardResponse.setCode("1");
        standardResponse.setMessage("success!!");
        return standardResponse;
    }

    public static StandardResponse failureStandardResponse() {
        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setSuccess(false);
        standardResponse.setCode("-1");
        standardResponse.setMessage("failure!!");
        return standardResponse;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
