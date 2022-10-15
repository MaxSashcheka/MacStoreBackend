package com.mac.macstore.bll.services;

import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.models.ProductEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository deviceRepository) {
        this.productRepository = deviceRepository;
    }

    public void create(ProductEntity entity) throws SQLException {
        productRepository.create(entity);
    }
    public void update(ProductEntity entity) throws SQLException {
        productRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        productRepository.delete(id);
    }
    public ArrayList<ProductEntity> getAll() throws SQLException {
       return productRepository.getAll();
    }
}
