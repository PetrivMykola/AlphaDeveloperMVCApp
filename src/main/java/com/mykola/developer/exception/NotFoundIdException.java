package main.java.com.mykola.developer.exception;

public class NotFoundIdException extends RuntimeException {
    String msg;

   public NotFoundIdException() {
        super();
    }

    public NotFoundIdException(String msg) {
       super(msg);
    }
}
