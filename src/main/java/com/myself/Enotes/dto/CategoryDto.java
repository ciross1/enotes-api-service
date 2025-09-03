package com.myself.Enotes.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

// Ein DTO (Data Transfer Object) ist ein einfaches Objekt, das hauptsächlich
// zum Transport von Daten zwischen verschiedenen Schichten einer Anwendung
// oder zwischen Anwendungen (z. B. Backend ↔ Frontend) verwendet wird.

@Data
public class CategoryDto {


    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    private Integer createdBy;
    private Date createdOn;
    private Integer updatedBy;
    private Date updatedOn;
}
