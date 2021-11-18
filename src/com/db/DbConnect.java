package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Administrator
 * 数据库连接
 */
public class DbConnect {
    private static Connection connection;
    private static final String URL="jdbc:mysql://localhost:3306/student";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="test";
    private static final String PASSWORD="cq2003";

    private static void init(){
        try{
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        init();
        return connection;
    }
}
