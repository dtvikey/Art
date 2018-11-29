package com.imooc.art.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: dtvikey
 * @Date: 27/11/18 下午 04:58
 * @Version 1.0
 * 登录
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/login.do".equals(req.getServletPath())){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            //如果用户名和密码相同且不为空，则登录成功。
            if(null!=username && !"".equals(username.trim()) && username.equals(password)){
                req.getSession().setAttribute("username",username);
                req.getRequestDispatcher("/art/list.do").forward(req,resp);
            }else{
                req.getRequestDispatcher("/art/login.do").forward(req,resp);
            }
        }else{
            req.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(req,resp);
        }
    }
}
