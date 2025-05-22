package com.furniture.InventoryManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "furniture_material")
public class FurnitureMaterialEntity {

    // id, timberType, timberSize(l*b*h), timberQuantity, makingProduct, makingWorker, makingStartDate, makingEndDate,
    // makingDayCount

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;

    @Column(name = "timber_type")
    private String timberType;

   // @Column(name = "timber_size")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<TimberSizeEntity> timberSize;

    @Column(name = "product")
    private String product;

    @Id
    @Column(name = "product_id")
    private long productId;

    @Column(name = "worker_name")
    private String workerName;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

//    @Column(name = "day_count")
//    private int dayCount;


}
