package com.mac.macstore.bll.abstractions.services;

import com.mac.macstore.bll.models.DeviceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDeviceService {
    public void create(DeviceEntity entity) throws SQLException;
    public void update(DeviceEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<DeviceEntity> getAll() throws SQLException;
}
