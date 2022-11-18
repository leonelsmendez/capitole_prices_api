package org.capitole.prices.api.exception.server;

public class InternalServerError extends RuntimeException {

    public static final int STATUS_CODE = 500;

    public static final String MESSAGE = "There was an error when running the application.";

    private String errorCode = "SERVER_ERROR";

    public InternalServerError() {
        super(MESSAGE);
    }

    public InternalServerError(String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public InternalServerError(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
