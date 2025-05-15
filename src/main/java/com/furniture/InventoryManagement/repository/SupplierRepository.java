package com.furniture.InventoryManagement.repository;

import com.furniture.InventoryManagement.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    @Query(name = "select * from supplier where supplier_name =:supplierName", nativeQuery = true)
    public boolean existsBySupplierName(String supplierName);

//    @Query(name = "select * from supplier", nativeQuery = true)
//    public List<SupplierEntity> fetchAllSuppliers();

}
