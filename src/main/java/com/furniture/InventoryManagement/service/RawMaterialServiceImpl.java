package com.furniture.InventoryManagement.service;

import com.furniture.InventoryManagement.entity.RawMaterialEntity;
import com.furniture.InventoryManagement.model.DateSearchModel;
import com.furniture.InventoryManagement.model.RawMaterialModel;
import com.furniture.InventoryManagement.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

    @Autowired
    private RawMaterialRepository rawMaterialRepository;


    @Override
    public RawMaterialModel addRawMaterial(RawMaterialModel model) {

        RawMaterialEntity entity = model.mapModelToEntity(model);
        rawMaterialRepository.save(entity);

        return model.mapEntityToModel(entity);
    }


    @Override
    public RawMaterialModel editRawMaterial(long id, RawMaterialModel model) {

        Optional<RawMaterialEntity> entity = rawMaterialRepository.findById(id);

        entity.ifPresent(e ->
                e.setSupplierName(Objects.equals(e.getSupplierName(), model.getSupplierName()) ||
                Objects.isNull(model.getSupplierName()) || model.getSupplierName().isBlank() ?
                e.getSupplierName() : model.getSupplierName()));

        entity.ifPresent(e ->
                e.setWoodType((Objects.equals(e.getWoodType(), model.getWoodType()) ||
                Objects.isNull(model.getWoodType()) || model.getWoodType().isBlank()) ?
                e.getWoodType() : model.getWoodType()));

        entity.ifPresent(e ->
                e.setQuantity((Objects.equals(e.getQuantity(), model.getQuantity()) ||
                Objects.isNull(model.getQuantity()) || model.getQuantity().isBlank()) ?
                e.getQuantity() : model.getQuantity()));

        entity.ifPresent(e ->
                e.setPurchasingCost(Objects.equals(e.getPurchasingCost(), model.getPurchasingCost()) ||
                model.getPurchasingCost() == 0 ?
                e.getPurchasingCost() : model.getPurchasingCost()));

        entity.ifPresent(e ->
                e.setModifyingDate(Timestamp.valueOf(LocalDateTime.now())));

        entity.ifPresent(e ->  rawMaterialRepository.save(e));
        entity.ifPresent(model :: mapEntityToModel);

        return model;
    }

    @Override
    public List<RawMaterialModel> fetchByDate(DateSearchModel dateSearchModel) {


        List<RawMaterialModel> modelList = new ArrayList<>();

        List<RawMaterialEntity> entityList =  rawMaterialRepository.fetchByStoringDateRange(
                dateSearchModel.getFromDate(), dateSearchModel.getToDate());

        for (RawMaterialEntity entity : entityList){

            RawMaterialModel model = new RawMaterialModel();
            model.mapEntityToModel(entity);

            modelList.add(model);
        }

        return modelList;
    }

    @Override
    public List<RawMaterialModel> fetchByStoringDate(LocalDate date) {

        List<RawMaterialModel> modelList = new ArrayList<>();

        List<RawMaterialEntity> entityList =  rawMaterialRepository.fetchByStoringDate(date);

        for (RawMaterialEntity entity : entityList){

            RawMaterialModel model = new RawMaterialModel();
            model.mapEntityToModel(entity);

            modelList.add(model);
        }

        return modelList;
    }

    @Override
    public String deleteEntryById(long id) {

        if(rawMaterialRepository.existsById(id)){
            rawMaterialRepository.deleteById(id);
            return "entry deleted successfully!!";
        }else {
            return "not exist";
        }

    }


}
