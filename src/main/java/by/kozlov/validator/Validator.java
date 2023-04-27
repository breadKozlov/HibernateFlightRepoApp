package by.kozlov.validator;

public interface Validator<T> {
    ValidationResult isValid(T object);
}
