package com.example.adventurexp_backend.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnector {

    private static Connection con;
    private static String db_url;
    private static String uid;
    private static String pwd;

    @Value("${spring.datasource.url}")
    public void setUrl(String url) {
        db_url = url;
    }

    @Value("${spring.datasource.username}")
    public void setUid(String usern) {
        uid = usern;
    }

    @Value("${spring.datasource.password}")
    public void setPwd(String pass) {
        pwd = pass;
    }

    public static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(db_url, uid, pwd);
        return con;
    }
}