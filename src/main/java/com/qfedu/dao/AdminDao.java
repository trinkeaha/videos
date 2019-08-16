package com.qfedu.dao;

import com.qfedu.entity.Admin;


public interface AdminDao {

    public Admin findByUsername(String username);
}
