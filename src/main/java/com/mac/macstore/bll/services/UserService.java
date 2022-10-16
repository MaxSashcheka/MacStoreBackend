package com.mac.macstore.bll.services;

import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.repositories.IUserRepository;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.abstractions.services.IUserService;
import com.mac.macstore.bll.models.ProductEntity;
import com.mac.macstore.bll.models.UserEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(UserEntity entity) throws SQLException {
        userRepository.create(entity);
    }
    public void update(UserEntity entity) throws SQLException {
        userRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        userRepository.delete(id);
    }
    public ArrayList<UserEntity> getAll() throws SQLException {
        return userRepository.getAll();
    }
}
