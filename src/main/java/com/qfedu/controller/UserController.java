package com.qfedu.controller;


import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser.do")
    @ResponseBody
    public String loginUser(@RequestParam("email")String email, @RequestParam("password")String password, HttpSession session){

        User user = userService.findByEmail(email);
        if (user == null) {
            return "false";
        } else {
            if (user.getPassword().equals(password)){
                session.setAttribute("userAccount",user.getEmail());
                session.setAttribute(StrUtils.LOGIN_USER,user);
                return "success";
            } else {
                return "false";
            }
        }
    }

    @RequestMapping("/insertUser.do")
    @ResponseBody
    public String insertUser(String email,String password,HttpSession session){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        try {
            userService.addUser(user);

        } catch (Exception e){
            return "false";
        }
        session.setAttribute("userAccount",user.getEmail());
        session.setAttribute(StrUtils.LOGIN_USER,user);
        return "success";
    }

    @RequestMapping("/validateEmail.do")
    @ResponseBody
    public String validateEmail(String email){
        User user = userService.findByEmail(email);
        if (user != null) {
            return "false";
        } else {
            return "success";
        }
    }


    @RequestMapping("/showMyProfile.do")
    public String myUserInfo(Model model,HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user",user);
        return "my_profile";
    }


    @RequestMapping("/loginOutUser.do")
    public String loginOutUser(HttpSession session){
        session.removeAttribute("userCount");
        session.removeAttribute(StrUtils.LOGIN_USER);
        return "redirect:/jsp/before/index.jsp";
    }


    @RequestMapping("/changeProfile.do")
    public String changeProfile(Model model,HttpSession session) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);

        model.addAttribute("user",user);
        return "change_profile";
    }

    @RequestMapping("/changeAvatar.do")
    public String changeAvatar(Model model,HttpSession session) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user",user);
        return "change_avatar";
    }

    @RequestMapping("/passwordSafe.do")
    public String passwordSafe(Model model,HttpSession session) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        model.addAttribute("user",user);
        return "password_safe";
    }

    @RequestMapping("/updateUser.do")
    public ModelAndView updateUser(User user,HttpSession session){
        Map<String, Object> map = new HashMap<>();

        try {
            userService.updateUser(user);
        } catch (Exception e) {
            map.put("msg", "");
        }
        User user1 = userService.findById(user.getId());
        map.put("msg", "");
        session.setAttribute(StrUtils.LOGIN_USER, user1);
        map.put("user",user1);
        return new ModelAndView("my_profile", map);
    }


    @RequestMapping("/updatePassword.do")
    @ResponseBody
    public String updatePassword(String password,HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        user.setPassword(password);
        try{
            userService.updateUser(user);
        } catch (Exception e){
            return "false";
        }
        return "success";

    }

    @RequestMapping("/upLoadImage.do")
    public ModelAndView updateImg(@RequestParam MultipartFile upfile,HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            return new ModelAndView("my_profile");
        }
        String dir = "D:\\Aword\\videos\\src\\main\\webapp\\upload";
        String fileName = upfile.getOriginalFilename();
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));

        fileName = fileName.replaceAll("-","");

        File dirFile = new File(dir);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        File newFile = new File(dir, fileName);
        try{
            upfile.transferTo(newFile);
        } catch (IOException e){
            e.printStackTrace();
        }
        user.setImgUrl(fileName);

        userService.updateUser(user);
        User user1 = userService.findById(user.getId());
        Map<String, Object> map = new HashMap<>();

        map.put("msg", "");
        session.setAttribute(StrUtils.LOGIN_ADMIN, user1);
        map.put("user",user1);
        return new ModelAndView("my_profile", map);
    }

}
