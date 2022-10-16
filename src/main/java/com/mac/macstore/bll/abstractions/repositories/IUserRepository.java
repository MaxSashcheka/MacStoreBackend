package com.mac.macstore.bll.abstractions.repositories;

import com.mac.macstore.bll.models.ProductEntity;
import com.mac.macstore.bll.models.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserRepository {
    public void create(UserEntity entity) throws SQLException;
    public void update(UserEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<UserEntity> getAll() throws SQLException;
}
