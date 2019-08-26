package com.cssl.controller;

import com.cssl.entity.User;
import com.cssl.service.UserService;
import com.cssl.vojo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    //登陆
    @RequestMapping("/login")
    public String login(String userName, String password, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5*60);
        User user1 =(User)session.getAttribute(userName);
        Integer code=2001;
        if(user1!=null&&user1.getUserName()==userName && user1.getPassword()==password){
            code=2002;
        }else{
            User user = userService.LoginUser(userName, password);
            if (user != null) {
                session.setAttribute("user", user);
                return "redirect:/subjectController/showAll";
            }
            code=2001;
        }
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        model.addAttribute("code", code);
        return "login";
    }
    //注册
    @RequestMapping("/reg")
    public String regUser(@Validated UserVo uvo, BindingResult br, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5*60);
        Integer code=1000;
        if (br.hasErrors()) {
            List<FieldError> fieldErrors = br.getFieldErrors();
            for (FieldError f : fieldErrors) {
                System.out.println("错误信息：" + f.getDefaultMessage());
                System.out.println("uvo.getUserName():+"+uvo.getUserName());
                System.out.println("uvo.getUserName():+"+uvo.getPassword());
                model.addAttribute("userName1", uvo.getUserName());
                model.addAttribute("password1", uvo.getPassword());
                model.addAttribute("zc", f.getDefaultMessage());
                return "regist";
            }
        } else {
            String s = countName(uvo.getUserName(), model);
            if("0".equals(s)){
                User user = new User();
                BeanUtils.copyProperties(uvo, user);
                Integer TFreg = userService.regUser(user);
                if (TFreg > 0) {
                    session.setAttribute("user", user);
                    return "redirect:/itemsController/showAll";
                }
            }else
                code=1999;
        }
        model.addAttribute("userName1", uvo.getUserName());
        model.addAttribute("password1", uvo.getPassword());
        model.addAttribute("zc", code);
        return "regist";
    }
    //用户名是否存在
    @RequestMapping("/countName")
    public @ResponseBody String countName(String userName,Model model) {
        model.addAttribute("code", 1005);
       return userService.countName(userName).toString();
    }
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request,String userName){
        HttpSession session = request.getSession();
        System.out.println("userName---------------"+userName);
        session.removeAttribute(userName);
        //session.invalidate();
        return "redirect:/login.html";
    }

}
