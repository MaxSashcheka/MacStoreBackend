package com.mac.macstore.dal.Connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static Statement statement;
    static {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javawork",
                    "root",
                    "rootroot"
            );
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
