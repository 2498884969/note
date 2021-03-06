package a.txxml;

public class BookStockExpection extends RuntimeException {

    public BookStockExpection() {
    }

    public BookStockExpection(String message) {
        super(message);
    }

    public BookStockExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockExpection(Throwable cause) {
        super(cause);
    }

    public BookStockExpection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
