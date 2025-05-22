package com.furniture.InventoryManagement.service;

import com.furniture.InventoryManagement.model.FurnitureMaterialModel;
import org.springframework.stereotype.Service;

@Service
public interface FurnitureMaterialService {


    public FurnitureMaterialModel addFurnitureMaterial(FurnitureMaterialModel model);
}
