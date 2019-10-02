package com.manish.dao;

import com.manish.model.User;

import java.util.List;

public interface UserDao {
    public void insertUser(User user);
    public User getUser(int id);
    public List<User> getUsers();
    public int deleteUser(int id);
    public static final String INSERT_INTO_USER = "insert into users values (?,?,?,?)";
    public static final String SELECT_FROM_USER_ID = "select * from users where id = ?";
    public static final String SELECT_ALL_USERS = "select * from users";
    public static final String DELETE_USER_ID = "delete from users";
}

