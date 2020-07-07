package cn.tyust.service;

import cn.tyust.pojo.User;

public interface UserService {
    User login(String name,String pwd);
}
