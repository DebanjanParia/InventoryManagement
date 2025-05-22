package com.furniture.InventoryManagement.controller;

import com.furniture.InventoryManagement.model.SupplierModel;
import com.furniture.InventoryManagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {


    @Autowired
    private SupplierService supplierService;
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<String> addSupplier(@RequestBody SupplierModel model){
        return new ResponseEntity<>(supplierService.addSupplier(model), HttpStatusCode.valueOf(200));
    }

    @CrossOrigin
    @PostMapping("/edit/{id}")
    public ResponseEntity<SupplierModel> editSupplier(@RequestBody SupplierModel model, @PathVariable long id){
        return new ResponseEntity<>(supplierService.editSupplier(model, id), HttpStatusCode.valueOf(201));
    }
    @CrossOrigin
    @PostMapping("/fetch/{id}")
    public ResponseEntity<SupplierModel> fetchSupplier( @PathVariable long id){
        return new ResponseEntity<>(supplierService.fetchSupplierById(id), HttpStatusCode.valueOf(202));
    }


    @PostMapping("/fetch-all-suppliers")
    public ResponseEntity<List<SupplierModel>> fetchAllSuppliers(){
        return new ResponseEntity<>(supplierService.fetchAllSuppliers(), HttpStatusCode.valueOf(203));
    }


    @DeleteMapping("/delete-supplier/{id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable long id){
        return new ResponseEntity<>(supplierService.deleteSupplierById(id), HttpStatusCode.valueOf(201));
    }


}
