package com.example.web;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int userId = Integer.parseInt(req.getParameter("userId"));//将获取的字串串参数转为int类型
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userService.registerUser(userId,username,password)){
            System.out.println("注册成功");
            req.getRequestDispatcher("/Pages/login.jsp").forward(req, resp);
        }else{
            System.out.println("注册失败");
            req.setAttribute("registerMassage", "注册失败，用户名已存在！");
            req.getRequestDispatcher("/Pages/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
