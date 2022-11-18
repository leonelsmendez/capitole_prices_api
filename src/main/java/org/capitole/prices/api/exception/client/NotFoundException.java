package org.capitole.prices.api.exception.client;

public class NotFoundException extends RuntimeException {

    public static final int STATUS_CODE = 404;

    public static final String MESSAGE = "The resource you're looking for was not found.";

    private String errorCode = "NO_FOUND";

    public NotFoundException() {
        super(MESSAGE);
    }

    public NotFoundException(String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public NotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
