package com.furniture.InventoryManagement.service;

import com.furniture.InventoryManagement.entity.SupplierEntity;
import com.furniture.InventoryManagement.model.SupplierModel;
import com.furniture.InventoryManagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public String addSupplier(SupplierModel model) {

        if (!supplierRepository.existsBySupplierName(model.getSupplierName())){

            supplierRepository.save(model.mapModelToEntity(model));
            return "supplier details add successfully!!";

        }

        return "supplier already exists!!";
    }


    @Override
    public SupplierModel editSupplier(SupplierModel model, long id) {


        Optional<SupplierEntity> entity = supplierRepository.findById(id);

        entity.ifPresent(u ->u.setSupplierName((!Objects.equals(u.getSupplierName(),model.getSupplierName())
                         && !Objects.isNull(model.getSupplierName()) && !model.getSupplierName().isBlank()
                        ? model.getSupplierName() : u.getSupplierName())));
        entity.ifPresent(u-> u.setContactDetails((!Objects.equals(u.getContactDetails(), model.getContactDetails())
                        && !Objects.isNull(model.getContactDetails()) && !model.getContactDetails().isEmpty())
                        ? model.getContactDetails() : u.getContactDetails()));

        entity.ifPresent(u -> u.setContactNumber(Objects.equals(u.getContactNumber(), model.getContactNumber()) && !model.getContactDetails().isEmpty()
                        ? model.getContactNumber() : u.getContactNumber()));

        entity.ifPresent(u-> u.setModifiedDate(Timestamp.valueOf(LocalDateTime.now())));

        entity.ifPresent(u-> supplierRepository.save(u));
        entity.ifPresent(model::mapEntityToModel);

        return model;
    }


    @Override
    public SupplierModel fetchSupplierById(long id) {

        try{
            SupplierModel model = new SupplierModel();
            Optional<SupplierEntity> entity = supplierRepository.findById(id);

            return model.mapEntityToModel(entity.get());
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    @Override
    public List<SupplierModel> fetchAllSuppliers() {

        List<SupplierModel> supplierModelsList = new ArrayList<>();
        List<SupplierEntity> supplierEntityList = new ArrayList<>();

        for (SupplierEntity entity : supplierEntityList = supplierRepository.findAll()){
            SupplierModel model = new SupplierModel();
            model.mapEntityToModel(entity);

            supplierModelsList.add(model);
        }

        return supplierModelsList;
    }


    @Override
    public String deleteSupplierById(long id) {

        if(supplierRepository.existsById(id)){
            supplierRepository.deleteById(id);
            return "successfully delete supplier!!";
        }else {
            return "Supplier does not exit";
        }

    }



}
