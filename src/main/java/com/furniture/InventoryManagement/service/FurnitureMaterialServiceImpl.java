package com.furniture.InventoryManagement.service;

import com.furniture.InventoryManagement.entity.FurnitureMaterialEntity;
import com.furniture.InventoryManagement.entity.TimberSizeEntity;
import com.furniture.InventoryManagement.model.ErrorModel;
import com.furniture.InventoryManagement.model.FurnitureMaterialModel;
import com.furniture.InventoryManagement.repository.FurnitureMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureMaterialServiceImpl implements FurnitureMaterialService{


    @Autowired
    private FurnitureMaterialRepository furnitureMaterialRepository;

    @Override
    public FurnitureMaterialModel addFurnitureMaterial(FurnitureMaterialModel model) {



        if(!furnitureMaterialRepository.existsByProductId(model.getProductId())){

            FurnitureMaterialEntity entity = model.mapModelToEntity();
           // TimberSizeEntity sizeEntity = new TimberSizeEntity();
            //furnitureMaterialRepository.save(entity);

//            List<TimberSizeEntity> timberEntities = model.getTimberSize().stream()
//                    .map(sizeModel -> {
//                       // TimberSizeEntity sizeEntity = new TimberSizeEntity();
//                        sizeEntity.setProductId(entity.getProductId());
//                        sizeEntity.setLength(sizeModel.getLength());
//                        sizeEntity.setWidth(sizeModel.getWidth());
//                        sizeEntity.setHeight(sizeModel.getHeight());
//                        return sizeEntity;
//                    })
//                    .toList();
//            entity.setTimberSize(timberEntities);

          // furnitureMaterialRepository.saveAll( e);
            furnitureMaterialRepository.save(entity);
            return model.mapEntityToModel(entity);
        }else {
            return new ErrorModel("you can not entry for the repetitive product");
        }
    }

}
