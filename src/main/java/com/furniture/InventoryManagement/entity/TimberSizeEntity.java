package com.furniture.InventoryManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "timber_size")
public class TimberSizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Id
    @Column(name = "product_id")
    private long productId;

    @Column(name = "length")
    private int length;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private  int height;

    @Column(name = "timber_quantity")
    private String timberQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private FurnitureMaterialEntity furnitureMaterial;

}
