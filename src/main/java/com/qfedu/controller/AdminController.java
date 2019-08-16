package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){
        Admin admin = adminService.findByUsername(username,password);

        session.setAttribute(StrUtils.LOGIN_ADMIN, admin);

        return new JsonResult(1,null);
    }

    @RequestMapping("/loginOut.do")
    public String loginOutUser(HttpSession session){
        session.removeAttribute(StrUtils.LOGIN_ADMIN);
        return "redirect:/login.html";
    }
}
