package com.empoluboyarov.core.exceptions;

/**
 * Created by Evgeniy on 10.05.2016.
 */
public class CurrencyException extends Exception {
    public CurrencyException() {
    }

    public CurrencyException(Throwable cause) {
        super(cause);
    }

    public CurrencyException(String message) {
        super(message);
    }

    public CurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
