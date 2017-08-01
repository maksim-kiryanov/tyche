package ru.mkiryanov.banners.rest.model;

/**
 * @author maksim-kiryanov
 */
public class CommonResponse {
    private boolean success;
    private String message;

    private CommonResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CommonResponse success(String message) {
        return new CommonResponse(true, message);
    }

    public static CommonResponse failed(String message) {
        return new CommonResponse(false, message);
    }
}
