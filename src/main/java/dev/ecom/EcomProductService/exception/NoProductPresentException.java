package dev.ecom.EcomProductService.exception;

public class NoProductPresentException extends RuntimeException{
    public NoProductPresentException() {
        super();
    }

    public NoProductPresentException(String message) {
        super(message);
    }

    public NoProductPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoProductPresentException(Throwable cause) {
        super(cause);
    }

    protected NoProductPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
