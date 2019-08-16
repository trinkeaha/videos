package com.qfedu.dao;

import com.qfedu.entity.User;

public interface UserDao {

    public User findByEmail(String email);

    public int addUser(User user);

    public int updateUser(User user);

    public User findById(Integer id);
}
