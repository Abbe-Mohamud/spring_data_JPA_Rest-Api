package se.lexicon.spring_data_jpa_assignment.exception;

public class AppResourceNotFoundException extends RuntimeException{

    public AppResourceNotFoundException(String message) {
        super(message);
    }
}
