package main.exceptions;

public class InvalidGridConfigurationException extends RuntimeException {
    public InvalidGridConfigurationException(String message) {
        super(message);
    }
}
