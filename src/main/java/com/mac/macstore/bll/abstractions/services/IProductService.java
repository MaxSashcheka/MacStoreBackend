package com.mac.macstore.bll.abstractions.services;

import com.mac.macstore.bll.models.ProductEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductService {
    public void create(ProductEntity entity) throws SQLException;
    public void update(ProductEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<ProductEntity> getAll() throws SQLException;
}
