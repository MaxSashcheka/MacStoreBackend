package com.mac.macstore.bll.abstractions.services;

import com.mac.macstore.bll.models.UserTypeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserTypeService {
    public void create(UserTypeEntity entity) throws SQLException;
    public void update(UserTypeEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<UserTypeEntity> getAll() throws SQLException;
}
