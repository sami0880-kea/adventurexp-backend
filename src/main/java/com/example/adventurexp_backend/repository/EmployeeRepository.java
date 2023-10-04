package com.example.adventurexp_backend.repository;


import com.example.adventurexp_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class EmployeeRepository {
    DBConnector connector;

    @Autowired
    public EmployeeRepository(DBConnector connector) {
        this.connector = connector;
    }


    public String createEmployee(Employee newEmployee) {
        try (Connection con = connector.getConnection()) {
            String SQL = "INSERT INTO employee (email, password) values (?,?);";
            PreparedStatement psmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, newEmployee.getEmail());
            psmt.setString(2, newEmployee.getPassword());
            psmt.executeUpdate();
            return newEmployee.getEmail();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

