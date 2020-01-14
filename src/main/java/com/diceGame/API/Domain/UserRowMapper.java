package com.diceGame.API.Domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User userSQL = new User();
        userSQL.setId(rs.getInt("id"));
        userSQL.setName(rs.getString("name"));
        userSQL.setDate();
        userSQL.setVictoryPercentage((rs.getDouble("victory_percentage")));

        return userSQL;

    }
}