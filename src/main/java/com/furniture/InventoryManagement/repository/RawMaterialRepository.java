package com.furniture.InventoryManagement.repository;

import com.furniture.InventoryManagement.entity.RawMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterialEntity, Long> {


    @Query(value = "select * from raw_material where storing_date between :fromDate and :toDate order by id", nativeQuery = true)
    public List<RawMaterialEntity> fetchByStoringDateRange(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    @Query(value = "select * from raw_material where storing_date =:storingDate  order by id", nativeQuery = true)
    public List<RawMaterialEntity> fetchByStoringDate( @Param("storingDate") LocalDate storingDate);


    //List<RawMaterialEntity> fetchByStoringDate(LocalDate date);
}
