package com.korostenskyi.app.core.exception;

public class MissingDataException extends BaseException {

    private static final String ERROR_MESSAGE = "MissingDataException: ";

    public MissingDataException(String message) {
        super(ERROR_MESSAGE + message);
    }

    public MissingDataException(final String fmt, final Object... args) {
        super(fmt, args);
    }
}
