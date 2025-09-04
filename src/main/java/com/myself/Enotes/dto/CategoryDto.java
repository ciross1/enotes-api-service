package com.myself.Enotes.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

// Ein DTO (Data Transfer Object) ist ein einfaches Objekt, das hauptsächlich
// zum Transport von Daten zwischen verschiedenen Schichten einer Anwendung
// oder zwischen Anwendungen (z. B. Backend ↔ Frontend) verwendet wird.

@Data
public class CategoryDto {


    private Integer id;

//    @NotBlank
//    @Min(value = 10, message = "min 10")
//    @Max(value = 100)
    private String name;

//    @NotBlank
//    @Min(value = 10 , message = "min 10")
//    @Max(value = 100)
    private String description;

//    @NotNull
    private Boolean isActive;
    private Integer createdBy;
    private Date createdOn;
    private Integer updatedBy;
    private Date updatedOn;
}
