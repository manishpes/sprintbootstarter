package com.manish.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>
{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setfName(resultSet.getString("fname"));
        user.setlName(resultSet.getString("lname"));
        user.setAddress(resultSet.getString("address"));
        return user;
    }
}
