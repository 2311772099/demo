package cn.tyust.controller;

import cn.tyust.pojo.User;
import cn.tyust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(String name, String pwd, HttpSession session) {
        User user = userService.login(name, pwd);
        if (user == null) {
            return false;
        }
        session.setAttribute("user", user);
        System.out.println("登录成功，用户-->"+user);
        return true;
    }

    @RequestMapping("/view")
    @ResponseBody
    public User view(HttpSession session){
        return (User) session.getAttribute("user");
    }
}
