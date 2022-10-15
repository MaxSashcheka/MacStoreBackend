package com.mac.macstore.bll.abstractions.repositories;

import com.mac.macstore.bll.models.DeviceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDeviceRepository {
    public void create(DeviceEntity entity) throws SQLException;
    public void update(DeviceEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<DeviceEntity> getAll() throws SQLException;
}
