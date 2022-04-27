package com.example.web;

import com.example.dao.AdminDao;
import com.example.dao.impl.AdminDaoImpl;
import com.example.pojo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.admin")
public class AdminOperateServlet extends HttpServlet {
    AdminDao adminDao = new AdminDaoImpl();

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

    protected void banPublish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AdminPublished> adminPublished = adminDao.adminPbMsg();
        req.setAttribute("AdminPbMsg", adminPublished);
        req.getRequestDispatcher("/Pages/adminManagePower.jsp").forward(req, resp);
    }

    //set ban = 1
    protected void banUserPb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        adminDao.banPbMsg(bookId);
        banPublish(req, resp);
    }

    protected void manageVip(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = adminDao.manageVip();
        req.setAttribute("userVip", users);
        req.getRequestDispatcher("/Pages/adminVip.jsp").forward(req, resp);
    }

    //set vip = 0
    protected void closeVip(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("user_id"));
        adminDao.closeDaoVip(userId);
        manageVip(req, resp);
    }

    protected void manageUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = adminDao.manageUser();
        req.setAttribute("userUp", users);
        req.getRequestDispatcher("/Pages/adminUser.jsp").forward(req, resp);
    }
    protected void becomeVip(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("user_id"));
        adminDao.becomeVip(userId);
        manageVip(req, resp);
    }
}
