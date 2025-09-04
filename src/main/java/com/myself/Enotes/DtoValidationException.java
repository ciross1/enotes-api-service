package com.myself.Enotes;

import java.util.Map;

public class DtoValidationException extends RuntimeException{

    private Map<String, Object> error;

    public DtoValidationException(Map<String, Object> error) {
        this.error = error;
    }

    public Map<String, Object> getErrors(){
        return error;
    }
}
