package main.exceptions;

public class InvalidOrientationException extends RuntimeException {
    public InvalidOrientationException(String message) {
        super(message);
    }
}
