package com.mac.macstore.bll.services;

import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.repositories.IProductTypeRepository;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.abstractions.services.IProductTypeService;
import com.mac.macstore.bll.models.ProductEntity;
import com.mac.macstore.bll.models.ProductTypeEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class ProductTypeService implements IProductTypeService {
    private IProductTypeRepository productTypeRepository;

    public ProductTypeService(IProductTypeRepository productTypeService) {
        this.productTypeRepository = productTypeService;
    }

    public void create(ProductTypeEntity entity) throws SQLException {
        productTypeRepository.create(entity);
    }
    public void update(ProductTypeEntity entity) throws SQLException {
        productTypeRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        productTypeRepository.delete(id);
    }
    public ArrayList<ProductTypeEntity> getAll() throws SQLException {
        return productTypeRepository.getAll();
    }
}
