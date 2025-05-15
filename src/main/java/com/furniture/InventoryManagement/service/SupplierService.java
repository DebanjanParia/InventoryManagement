package com.furniture.InventoryManagement.service;

import com.furniture.InventoryManagement.model.SupplierModel;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public interface SupplierService {

    public String addSupplier(SupplierModel model);

    public SupplierModel editSupplier(SupplierModel model, long id);

    public SupplierModel fetchSupplierById(long id);

    public List<SupplierModel> fetchAllSuppliers();

    public String deleteSupplierById(long id);

}
