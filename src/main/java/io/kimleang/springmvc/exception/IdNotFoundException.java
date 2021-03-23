package io.kimleang.springmvc.exception;

public class IdNotFoundException extends Exception {
    private String message;

    public IdNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "IdNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }
}
