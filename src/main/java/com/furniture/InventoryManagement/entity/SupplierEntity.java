package com.furniture.InventoryManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "contact_details")
    private String contactDetails;

    @Column(name = "contact_number")
    private long contactNumber;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;


}
