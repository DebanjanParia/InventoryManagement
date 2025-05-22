package com.furniture.InventoryManagement.controller;

import com.furniture.InventoryManagement.model.FurnitureMaterialModel;
import com.furniture.InventoryManagement.service.FurnitureMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/inventory/furniture-material")
public class FurnitureMaterialController {



    @Autowired
    private FurnitureMaterialService furnitureMaterialService;


    @PostMapping("/add")
    public ResponseEntity<FurnitureMaterialModel> add(@RequestBody FurnitureMaterialModel model){
        return new ResponseEntity<>(furnitureMaterialService.addFurnitureMaterial(model), HttpStatusCode.valueOf(201));
    }

}
