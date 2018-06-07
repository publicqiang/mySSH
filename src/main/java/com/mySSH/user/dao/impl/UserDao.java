package com.mySSH.user.dao.impl;

import com.mySSH.base.dao.impl.BaseDao;
import com.mySSH.user.dao.IUserDao;
import com.mySSH.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

}
