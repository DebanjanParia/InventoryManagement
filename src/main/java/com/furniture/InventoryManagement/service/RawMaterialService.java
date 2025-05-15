package com.furniture.InventoryManagement.service;

import com.furniture.InventoryManagement.model.DateSearchModel;
import com.furniture.InventoryManagement.model.RawMaterialModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface RawMaterialService {

    public RawMaterialModel addRawMaterial(RawMaterialModel model);

    public RawMaterialModel editRawMaterial(long id, RawMaterialModel model);

    public List<RawMaterialModel> fetchByDate(DateSearchModel model);

    public List<RawMaterialModel> fetchByStoringDate(LocalDate date);

    public String deleteEntryById(long id);
}
