package com.furniture.InventoryManagement.controller;

import com.furniture.InventoryManagement.model.DateSearchModel;
import com.furniture.InventoryManagement.model.RawMaterialModel;
import com.furniture.InventoryManagement.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/management/inventory/raw-material")
public class RawMaterialController {


    @Autowired
    private RawMaterialService rawMaterialService;


    @PostMapping("/add")
    public ResponseEntity<RawMaterialModel> addRawMaterial(@RequestBody RawMaterialModel model){
        return new ResponseEntity<>(rawMaterialService.addRawMaterial(model), HttpStatusCode.valueOf(201));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<RawMaterialModel> editRawMaterial(@PathVariable long id, @RequestBody RawMaterialModel model){
        return new ResponseEntity<>(rawMaterialService.editRawMaterial(id, model), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/fetch-by-date-range")
    public ResponseEntity<List<RawMaterialModel>> fetchByStoringDateBewteen(@RequestBody DateSearchModel model){
        return new ResponseEntity<>(rawMaterialService.fetchByDate(model), HttpStatusCode.valueOf(201));
    }

    @PostMapping("/fetch-by-Storing-date")
    public ResponseEntity<List<RawMaterialModel>> fetchByStoringDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(rawMaterialService.fetchByStoringDate(date), HttpStatusCode.valueOf(201));
    }

    @PostMapping("/erase-entry")
    public ResponseEntity<String> eraseEntryById(@PathVariable long id){
        return new ResponseEntity<>(rawMaterialService.deleteEntryById(id), HttpStatusCode.valueOf(205));
    }




}
