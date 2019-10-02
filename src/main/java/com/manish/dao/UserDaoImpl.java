package com.manish.dao;

import com.manish.model.User;
import com.manish.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){

    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void insertUser(User user) {
        jdbcTemplate.update(INSERT_INTO_USER, user.getId(), user.getfName(), user.getlName(), user.getAddress());
        System.out.println("User Added");
    }

    @Override
    public User getUser(int id) {
        User user = jdbcTemplate.queryForObject(SELECT_FROM_USER_ID, new UserMapper(), id);
        return user;
    }

    @Override
    public List<User> getUsers() {
       List users =  jdbcTemplate.query(SELECT_ALL_USERS, new UserMapper());
        return users;
    }

    @Override
    public int deleteUser(int id) {
      int res =   jdbcTemplate.update(DELETE_USER_ID, id);
      return res;
    }
}
