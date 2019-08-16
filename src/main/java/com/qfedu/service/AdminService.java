package com.qfedu.service;

import com.qfedu.entity.Admin;

public interface AdminService {

    public Admin findByUsername(String username,String password);

}
