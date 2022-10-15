package com.mac.macstore.dal.reps;


import com.mac.macstore.bll.abstractions.repositories.IDeviceRepository;
import com.mac.macstore.bll.models.DeviceEntity;
import com.mac.macstore.dal.Connectors.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class DeviceRepository implements IDeviceRepository {
    public void create(DeviceEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("INSERT INTO device (name, price) VALUES ('%s', %s)", entity.name, entity.price));
    }
    public void update(DeviceEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("UPDATE device set name = '%s', price = %s where id = %s", entity.name, entity.price, entity.id));
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM device where id = %s", id));
    }
    public ArrayList<DeviceEntity> getAll() throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(String.format("SELECT * FROM device"));
        var result = new ArrayList<DeviceEntity>(0);
        while (resultSet.next())
        {
            var device = new DeviceEntity();
            device.id = resultSet.getInt("id");
            device.name = resultSet.getString("name");
            device.price = resultSet.getInt("price");
            result.add(device);
        }
        return result;
    }
}
