package com.myself.Enotes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
// @MappedSuperclass nutzt man, um gemeinsame Felder für Entities in
// einer Basisklasse zu definieren,
// ohne dass dafür eine eigene Tabelle erzeugt wird.
public class BaseModel {

    private Boolean isActive;
    private Boolean isDeleted;
    private Integer createdBy;
    private Date createdOn;
    private Integer updatedBy;
    private Date updatedOn;
}
