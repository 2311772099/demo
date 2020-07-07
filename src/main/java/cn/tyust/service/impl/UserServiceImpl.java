package cn.tyust.service.impl;

import cn.tyust.mapper.UserMapper;
import cn.tyust.pojo.User;
import cn.tyust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String name, String pwd) {
        User user = userMapper.selOneByName(name);
        if(user==null||!(user.getPwd().equals(pwd))){
            System.out.println("登录时账户或密码错误！");
            return null;
        }
        return user;
    }
}
