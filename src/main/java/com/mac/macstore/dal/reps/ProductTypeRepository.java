package com.mac.macstore.dal.reps;

import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.repositories.IProductTypeRepository;
import com.mac.macstore.bll.models.ProductEntity;
import com.mac.macstore.bll.models.ProductTypeEntity;
import com.mac.macstore.dal.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class ProductTypeRepository implements IProductTypeRepository {
    public void create(ProductTypeEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("INSERT INTO product_type (name) VALUES ('%s')", entity.name)
        );
    }

    public void update(ProductTypeEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("UPDATE product_type set name = '%s' where id = %s",
                        entity.name,
                        entity.id)
        );
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM product_type where id = %s", id));
    }
    public ArrayList<ProductTypeEntity> getAll() throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(String.format("SELECT * FROM product_type"));
        var result = new ArrayList<ProductTypeEntity>(0);
        while (resultSet.next()) {
            var product = new ProductTypeEntity();
            product.id = resultSet.getInt("id");
            product.name = resultSet.getString("name");

            result.add(product);
        }
        return result;
    }
}
