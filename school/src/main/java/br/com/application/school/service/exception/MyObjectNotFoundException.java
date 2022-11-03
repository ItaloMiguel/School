package br.com.application.school.service.exception;

public class MyObjectNotFoundException extends RuntimeException {

    public MyObjectNotFoundException(String message) {
        super(message);
    }
}
