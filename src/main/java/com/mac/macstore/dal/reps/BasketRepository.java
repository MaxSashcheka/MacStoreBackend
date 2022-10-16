package com.mac.macstore.dal.reps;

import com.mac.macstore.bll.abstractions.repositories.IBasketRepository;
import com.mac.macstore.bll.models.BasketEntity;
import com.mac.macstore.bll.models.UserTypeEntity;
import com.mac.macstore.dal.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class BasketRepository implements IBasketRepository {
    public void create(BasketEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("INSERT INTO basket (product_id, user_id, count) VALUES (%s, %s, %s)",
                        entity.product_id,
                        entity.user_id,
                        entity.count
                )
        );
    }

    public void update(BasketEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("UPDATE basket set count = %s where user_id = %s and product_id = %s",
                        entity.count,
                        entity.user_id,
                        entity.product_id
                )
        );
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM basket where user_id = %s", id));
    }
    public ArrayList<BasketEntity> getAll(int id) throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(
                String.format("SELECT * FROM basket where user_id = %s", id)
        );
        var result = new ArrayList<BasketEntity>(0);
        while (resultSet.next()) {
            var basket = new BasketEntity();
            basket.user_id = resultSet.getInt("user_id");
            basket.product_id = resultSet.getInt("product_id");
            basket.count = resultSet.getInt("count");

            result.add(basket);
        }
        return result;
    }
}

