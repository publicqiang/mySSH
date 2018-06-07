package com.mySSH.user.service.impl;

import com.mySSH.user.dao.IUserDao;
import com.mySSH.user.entity.User;
import com.mySSH.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Resource
    private IUserDao userDao;


    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }
}
