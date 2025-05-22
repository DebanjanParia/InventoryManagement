package com.furniture.InventoryManagement.repository;

import com.furniture.InventoryManagement.entity.FurnitureMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FurnitureMaterialRepository extends JpaRepository<FurnitureMaterialEntity, Long> {

    @Query
    public boolean existsByProductId(long productId);
}