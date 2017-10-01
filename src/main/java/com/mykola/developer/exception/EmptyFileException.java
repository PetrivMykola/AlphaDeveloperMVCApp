package main.java.com.mykola.developer.exception;

public class EmptyFileException extends RuntimeException {
    String msg;

   public EmptyFileException(String msg) {
        super(msg);
    }

    public EmptyFileException() {
        super();
    }
}
