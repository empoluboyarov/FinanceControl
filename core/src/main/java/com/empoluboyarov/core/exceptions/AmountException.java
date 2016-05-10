package com.empoluboyarov.core.exceptions;

/**
 * Created by Evgeniy on 10.05.2016.
 */
public class AmountException extends Exception {
    public AmountException() {
    }

    public AmountException(Throwable cause) {
        super(cause);
    }

    public AmountException(String message) {
        super(message);
    }

    public AmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
