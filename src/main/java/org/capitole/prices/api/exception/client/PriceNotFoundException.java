package org.capitole.prices.api.exception.client;

public class PriceNotFoundException extends NotFoundException {

    private String message;

    public PriceNotFoundException(String message) {
        super(message);
    }

    public PriceNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}
