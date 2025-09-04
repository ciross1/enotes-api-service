package com.myself.Enotes.util;

import com.myself.Enotes.DtoValidationException;
import com.myself.Enotes.dto.CategoryDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Validation {

    Map<String, Object> error = new LinkedHashMap<>();


    public void categoryValidation(CategoryDto categoryDto) {

        if (ObjectUtils.isEmpty(categoryDto)) {
            throw new IllegalArgumentException("category object/json shoulnt be null or empty");
        } else {

            //Validation name field:
            if (ObjectUtils.isEmpty(categoryDto.getName())) {
                error.put("name", "name field is empty or null");
            } else {
                if (categoryDto.getName().length() < 10) {
                    error.put("name", "name length min 10");
                }
                if (categoryDto.getName().length() > 100) {
                    error.put("name", "name length max 100");
                }

            }

            // Description
            if (ObjectUtils.isEmpty(categoryDto.getDescription())) {
                error.put("Description", "Description field is empty or null");
            } else {
                if (categoryDto.getDescription().length() < 10) {
                    error.put("Description", "Description length min 10");
                }
                if (categoryDto.getDescription().length() > 100) {
                    error.put("Description", "Description length max 100");
                }

                //Validation is Active

                if (ObjectUtils.isEmpty(categoryDto.getIsActive())) {
                    error.put("isActive", "isActive field is empty or null");
                } else {
                    if (categoryDto.getIsActive() != Boolean.TRUE.booleanValue()
                            && categoryDto.getIsActive() != Boolean.FALSE.booleanValue()) {
                        error.put("isActive", "invalid value isActive field");
                    }


                }
            }
        }

        if(!error.isEmpty()){
            throw new DtoValidationException(error);
        }

    }
}
