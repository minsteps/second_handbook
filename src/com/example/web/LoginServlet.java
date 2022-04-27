package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.enter")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String methodName = servletPath.substring(1, servletPath.length() - 6);
        System.out.println(methodName);
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    protected void getAllUsersMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        resp.setContentType("text/html;charset=utf-8");
        List<User> users = userService.getAllUser();
        for (User each : users) {
            resp.getWriter().println(each.toString());
        }
        System.out.println(users);
    }

    protected void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        resp.setContentType("text/html;charset=utf-8");
        int user_id = Integer.parseInt(req.getParameter("userId"));

        String password = req.getParameter("password");
        Boolean flag = userService.showOneUser(user_id, password);

        if (flag){//登陆成功
            System.out.println("登陆成功");
            //把账号放到session
            HttpSession session = req.getSession();
            session.setAttribute("userid", user_id);
            req.getRequestDispatcher("/Pages/userBackstage.jsp").forward(req, resp);
        }else {//登陆失败
            req.setAttribute("Massage", "账号或者密码输入有误或者输入为空，请重新输入");
            req.getRequestDispatcher("/Pages/login.jsp").forward(req, resp);
        }
    }

    protected void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int user_id = Integer.parseInt(req.getParameter("aid"));
        String password = req.getParameter("password");

        if (user_id == 666 && password.equals("admin")){//登陆成功
            System.out.println("登陆成功");
            req.getRequestDispatcher("/Pages/adminBackstage.jsp").forward(req, resp);
        }else {//登陆失败
            req.setAttribute("Massage", "账号或者密码输入有误或者输入为空，请重新输入");
            req.getRequestDispatcher("/Pages/adminLogin.jsp").forward(req, resp);
        }
    }

}
