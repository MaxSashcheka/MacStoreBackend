package com.mac.macstore.bll.abstractions.repositories;

import com.mac.macstore.bll.models.ProductTypeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductTypeRepository {
    public void create(ProductTypeEntity entity) throws SQLException;
    public void update(ProductTypeEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<ProductTypeEntity> getAll() throws SQLException;
}
