package com.furniture.InventoryManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.InventoryManagement.entity.FurnitureMaterialEntity;
import com.furniture.InventoryManagement.entity.TimberSizeEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
public class FurnitureMaterialModel {

//    @JsonProperty("id")
//    private long id;

    @JsonProperty("timberType")
    private String timberType;

    @JsonProperty("timberSize")
    private List<TimberSizeModel> timberSize;

    @JsonProperty("product")
    private String product;

    @JsonProperty("productId")
    private long productId;

    @JsonProperty("workerName")
    private String workerName;

    @JsonProperty("startDate")
    private Timestamp startDate;

//    @JsonProperty("endDate")
//    private Timestamp endDate;

//    @JsonProperty("dayCount")
//    private int dayCount;

    @JsonProperty("modificationDate")
    private Timestamp modificationDate;


    public FurnitureMaterialEntity mapModelToEntity() {

        FurnitureMaterialEntity entity = new FurnitureMaterialEntity();

        Random random = new Random();

        entity.setProduct(this.getProduct());
        entity.setProductId(random.nextLong(10000,99999));
        entity.setTimberType(this.getTimberType());

        List<TimberSizeEntity> timberEntities = this.getTimberSize().stream()
                .map(sizeModel -> {
                    TimberSizeEntity sizeEntity = new TimberSizeEntity();
                    sizeEntity.setProductId(entity.getProductId());
                    sizeEntity.setLength(sizeModel.getLength());
                    sizeEntity.setWidth(sizeModel.getWidth());
                    sizeEntity.setHeight(sizeModel.getHeight());
                    sizeEntity.setTimberQuantity(sizeModel.getTimberQuantity());
                    return sizeEntity;
                })
                .collect(Collectors.toList());

        entity.setTimberSize(timberEntities);

        entity.setWorkerName(this.getWorkerName());
        entity.setStartDate(Timestamp.valueOf(LocalDateTime.now()));
        entity.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));


        return entity;
    }

    public FurnitureMaterialModel mapEntityToModel(FurnitureMaterialEntity entity){

        this.setProductId(entity.getProductId());
        this.setProduct(entity.getProduct());

        List<TimberSizeModel> sizeEntityList = entity.getTimberSize().stream().map(sizeEntity ->{
            TimberSizeModel model = new TimberSizeModel();
           // model.setId(this.getTimberSize().get(0).getId());
            model.setProductId(sizeEntity.getProductId());
            model.setWidth(sizeEntity.getWidth());
            model.setLength(sizeEntity.getLength());
            model.setHeight(sizeEntity.getHeight());
            model.setTimberQuantity(sizeEntity.getTimberQuantity());
            return model;
        }).toList();
        this.setTimberSize(sizeEntityList);

        this.setTimberType(entity.getTimberType());
        this.setWorkerName(entity.getWorkerName());
        this.setStartDate(entity.getStartDate());
        this.setModificationDate(entity.getModifiedDate());


        return this;
    }


}
