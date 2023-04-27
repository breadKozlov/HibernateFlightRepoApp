package by.kozlov.validator;

import lombok.Value;

@Value
public class Error {
    String code;
    String message;

    private Error(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public static Error of(String code,String message) {
        return new Error(code,message);
    }
}