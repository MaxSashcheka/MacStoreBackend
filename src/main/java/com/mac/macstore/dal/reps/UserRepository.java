package com.mac.macstore.dal.reps;

import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.repositories.IUserRepository;
import com.mac.macstore.bll.models.UserEntity;
import com.mac.macstore.dal.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class UserRepository implements IUserRepository {
    public void create(UserEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("INSERT INTO user (first_name, last_name, user_type_id, login, password) VALUES ('%s', '%s', %s, '%s', '%s')",
                        entity.first_name,
                        entity.last_name,
                        entity.user_type_id,
                        entity.login,
                        entity.password)
        );
    }
    public void update(UserEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("UPDATE user set first_name = '%s', last_name = '%s', login = '%s', password = '%s' where id = %s",
                        entity.first_name,
                        entity.last_name,
                        entity.login,
                        entity.password,
                        entity.id
                )
        );
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM user where id = %s", id));
    }
    public ArrayList<UserEntity> getAll() throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(String.format("SELECT * FROM user"));
        var result = new ArrayList<UserEntity>(0);
        while (resultSet.next()) {
            var product = new UserEntity();
            product.id = resultSet.getInt("id");
            product.first_name = resultSet.getString("first_name");
            product.last_name = resultSet.getString("last_name");
            product.user_type_id = resultSet.getInt("user_type_id");
            product.login = resultSet.getString("login");
            product.password = resultSet.getString("password");

            result.add(product);
        }
        return result;
    }
}
