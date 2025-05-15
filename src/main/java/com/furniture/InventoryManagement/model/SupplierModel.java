package com.furniture.InventoryManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.InventoryManagement.entity.SupplierEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class SupplierModel {


    @JsonProperty("id")
    private long id;

    @JsonProperty("supplierName")
    private String supplierName;

    @JsonProperty("contactDetails")
    private String contactDetails;

    @JsonProperty("contactNumber")
    private long contactNumber;

    @JsonProperty("entryDate")
    private LocalDate entryDate;

    @JsonProperty("modifiedDate")
    private Timestamp modifiedDate;


    public SupplierEntity mapModelToEntity(SupplierModel model){

        SupplierEntity entity = new SupplierEntity();

        entity.setSupplierName(model.getSupplierName());
        entity.setContactDetails(model.getContactDetails());
        entity.setContactNumber(model.getContactNumber());
        entity.setEntryDate(LocalDate.now());
        entity.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));

        return entity;
    }

    public SupplierModel mapEntityToModel(SupplierEntity entity){

        this.setId(entity.getId());
        this.setSupplierName(entity.getSupplierName());
        this.setContactDetails(entity.getContactDetails());
        this.setContactNumber(entity.getContactNumber());
        this.setEntryDate(entity.getEntryDate());
        this.setModifiedDate(entity.getModifiedDate());

        return this;
    }


}
