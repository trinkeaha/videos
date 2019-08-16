package com.qfedu.service.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;
    @Override
    public Admin findByUsername(String username,String password) {
        Admin admin = adminDao.findByUsername(username);
        if(admin == null){
            throw new RuntimeException("账号错误");
        }
        if(!admin.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return admin;
    }
}
