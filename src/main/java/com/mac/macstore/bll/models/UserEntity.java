package com.mac.macstore.bll.models;

public class UserEntity {
    public int id;
    public String first_name;
    public String last_name;
    public int user_type_id;
    public String login;
    public String password;

    public UserEntity(int id, String first_name, String last_name,
                      int user_type_id, String login, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_type_id = user_type_id;
        this.login = login;
        this.password = password;
    }

    public UserEntity() {
    }
}