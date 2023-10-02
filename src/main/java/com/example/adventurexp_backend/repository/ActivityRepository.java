package com.example.adventurexp_backend.repository;

import com.example.adventurexp_backend.model.Activity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityRepository {
    DBConnector connector;

    public List<Activity> viewActivities() {
        List<Activity> activities = new ArrayList< >();
        try (Connection con = DBConnector.getConnection()) {

            String SQL = "SELECT * FROM activities";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("activity_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                int minAge = rs.getInt("min_age");
                activities.add(new Activity(id, name, description, image, minAge));
            }
            return activities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
