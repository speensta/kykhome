package com.example.kykhome.exception;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    private int code;
    private HashMap<String, String> fieldValidators = new HashMap();

    public void putFieldValidators(String fieldName, String message) {
        this.fieldValidators.put(fieldName, message);
    }

}
