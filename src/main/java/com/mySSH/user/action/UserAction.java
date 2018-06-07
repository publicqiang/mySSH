package com.mySSH.user.action;

import com.mySSH.user.entity.User;
import com.mySSH.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private User user;
    @Autowired
    private IUserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String findAll() throws Exception {
        HttpSession session = request.getSession();
        List<User> users = userService.findAll();
        if (users != null && users.size() > 0) {
            session.setAttribute("users", users);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
