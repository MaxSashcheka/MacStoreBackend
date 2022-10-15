package com.mac.macstore.dal.reps;


import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.models.ProductEntity;
import com.mac.macstore.dal.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class ProductRepository implements IProductRepository {
    public void create(ProductEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("INSERT INTO product (name, price, product_type_id) VALUES ('%s', %s, %s)",
                entity.name,
                entity.price,
                entity.product_type_id)
        );
    }
    public void update(ProductEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("UPDATE product set name = '%s', price = %s where id = %s",
                        entity.name,
                        entity.price,
                        entity.id)
        );
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM product where id = %s", id));
    }
    public ArrayList<ProductEntity> getAll() throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(String.format("SELECT * FROM product"));
        var result = new ArrayList<ProductEntity>(0);
        while (resultSet.next()) {
            var product = new ProductEntity();
            product.id = resultSet.getInt("id");
            product.name = resultSet.getString("name");
            product.price = resultSet.getInt("price");
            product.product_type_id = resultSet.getInt("product_type_id");

            result.add(product);
        }
        return result;
    }
}
