package com.mac.macstore.bll.services;

import com.mac.macstore.bll.abstractions.repositories.IProductTypeRepository;
import com.mac.macstore.bll.abstractions.repositories.IUserTypeRepository;
import com.mac.macstore.bll.abstractions.services.IProductTypeService;
import com.mac.macstore.bll.abstractions.services.IUserTypeService;
import com.mac.macstore.bll.models.ProductTypeEntity;
import com.mac.macstore.bll.models.UserTypeEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class UserTypeService implements IUserTypeService {
    private IUserTypeRepository userTypeRepository;

    public UserTypeService(IUserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public void create(UserTypeEntity entity) throws SQLException {
        userTypeRepository.create(entity);
    }
    public void update(UserTypeEntity entity) throws SQLException {
        userTypeRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        userTypeRepository.delete(id);
    }
    public ArrayList<UserTypeEntity> getAll() throws SQLException {
        return userTypeRepository.getAll();
    }
}
