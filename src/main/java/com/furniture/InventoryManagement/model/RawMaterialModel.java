package com.furniture.InventoryManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.InventoryManagement.entity.RawMaterialEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class RawMaterialModel {

    @JsonProperty("id")
    private long id;

    @JsonProperty("supplierId")
    private long supplierId;

    @JsonProperty("supplierName")
    private String supplierName;

    @JsonProperty("woodType")
    private String woodType;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("purchasingCost")
    private double purchasingCost;

    @JsonProperty("storingDate")
    private LocalDate storingDate;

    @JsonProperty("modifyingDate")
    private Timestamp modifyingDate;



    public RawMaterialEntity mapModelToEntity(RawMaterialModel model) {

        RawMaterialEntity entity = new RawMaterialEntity();

        entity.setSupplierId(model.getSupplierId());
        entity.setSupplierName(model.getSupplierName());
        entity.setWoodType(model.getWoodType());
        entity.setQuantity(model.getQuantity());
        entity.setPurchasingCost(model.getPurchasingCost());
        entity.setStoringDate(LocalDate.now());
        entity.setModifyingDate(Timestamp.valueOf(LocalDateTime.now()));

        return entity;
    }


    public RawMaterialModel mapEntityToModel(RawMaterialEntity entity) {

        this.setId(entity.getId());
        this.setSupplierId(entity.getSupplierId());
        this.setSupplierName(entity.getSupplierName());
        this.setWoodType(entity.getWoodType());
        this.setQuantity(entity.getQuantity());
        this.setPurchasingCost(entity.getPurchasingCost());
        this.setStoringDate(entity.getStoringDate());
        this.setModifyingDate(entity.getModifyingDate());

        return this;
    }
}
