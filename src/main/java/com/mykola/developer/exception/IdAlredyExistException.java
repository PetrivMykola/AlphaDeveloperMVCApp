package main.java.com.mykola.developer.exception;

public class IdAlredyExistException extends RuntimeException {
    String msg;

   public IdAlredyExistException (String msg) {
       super(msg);

    }

   public IdAlredyExistException() {
       super();
    }
}
