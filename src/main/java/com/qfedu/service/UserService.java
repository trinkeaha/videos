package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {

    public User findByEmail(String email);

    public int addUser(User user);

    public int updateUser(User user);

    public User findById(Integer id);
}
