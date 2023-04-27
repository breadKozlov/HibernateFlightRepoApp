package by.kozlov.exception;

import lombok.Getter;

import java.util.List;
import by.kozlov.validator.Error;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}

