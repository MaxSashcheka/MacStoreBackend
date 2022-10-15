package com.mac.macstore.bll.services;

import com.mac.macstore.bll.abstractions.repositories.IDeviceRepository;
import com.mac.macstore.bll.abstractions.services.IDeviceService;
import com.mac.macstore.bll.models.DeviceEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class DeviceService implements IDeviceService {

    private IDeviceRepository deviceRepository;

    public DeviceService(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public void create(DeviceEntity entity) throws SQLException {
        deviceRepository.create(entity);
    }
    public void update(DeviceEntity entity) throws SQLException {
        deviceRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        deviceRepository.delete(id);
    }
    public ArrayList<DeviceEntity> getAll() throws SQLException {
       return deviceRepository.getAll();
    }
}
