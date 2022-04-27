package com.example.web;

import com.example.pojo.BookMessage;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/publishedMsg.do")
public class QueryPublishedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = req.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<BookMessage> bookMsg = userService.queryPublishedBookMsg(user_id);
        req.setAttribute("queryPublishedBookMsg", bookMsg);
        req.getRequestDispatcher("/Pages/selfPublished.jsp").forward(req, resp);
    }
}
