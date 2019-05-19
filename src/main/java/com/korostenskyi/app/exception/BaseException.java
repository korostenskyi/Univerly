package com.korostenskyi.app.exception;

public class BaseException extends RuntimeException {

    public BaseException() {

    }

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String fmt, final Object... args) {
        super(String.format(fmt, args));
    }
}
