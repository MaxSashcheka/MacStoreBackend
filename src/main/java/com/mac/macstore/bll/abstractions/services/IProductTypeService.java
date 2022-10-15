package com.mac.macstore.bll.abstractions.services;

import com.mac.macstore.bll.models.ProductEntity;
import com.mac.macstore.bll.models.ProductTypeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductTypeService {
    public void create(ProductTypeEntity entity) throws SQLException;
    public void update(ProductTypeEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<ProductTypeEntity> getAll() throws SQLException;
}
