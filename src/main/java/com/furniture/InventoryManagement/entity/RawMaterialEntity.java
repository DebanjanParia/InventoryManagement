package com.furniture.InventoryManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "raw_material")
public class RawMaterialEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "wood_type")
    private String woodType;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "purchasing_cost")
    private double purchasingCost;

    @Column(name = "storing_date")
    private LocalDate storingDate;

    @Column(name = "modifying_date")
    private Timestamp modifyingDate;

    @Column(name = "supplier_name")
    private String supplierName;



}
