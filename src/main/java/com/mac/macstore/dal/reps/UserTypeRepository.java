package com.mac.macstore.dal.reps;

import com.mac.macstore.bll.abstractions.repositories.IProductTypeRepository;
import com.mac.macstore.bll.abstractions.repositories.IUserTypeRepository;
import com.mac.macstore.bll.models.ProductTypeEntity;
import com.mac.macstore.bll.models.UserTypeEntity;
import com.mac.macstore.dal.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class UserTypeRepository implements IUserTypeRepository {
    public void create(UserTypeEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("INSERT INTO user_type (type) VALUES ('%s')", entity.type)
        );
    }

    public void update(UserTypeEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(
                String.format("UPDATE user_type set type = '%s' where id = %s",
                        entity.type,
                        entity.id)
        );
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM user_type where id = %s", id));
    }
    public ArrayList<UserTypeEntity> getAll() throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(String.format("SELECT * FROM user_type"));
        var result = new ArrayList<UserTypeEntity>(0);
        while (resultSet.next()) {
            var userType = new UserTypeEntity();
            userType.id = resultSet.getInt("id");
            userType.type = resultSet.getString("type");

            result.add(userType);
        }
        return result;
    }
}
