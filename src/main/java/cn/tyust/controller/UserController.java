package cn.tyust.controller;

import cn.tyust.pojo.User;
import cn.tyust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody User u, HttpSession session) {
        User user = userService.login(u.getName(), u.getPwd());
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
