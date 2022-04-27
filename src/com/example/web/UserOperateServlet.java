package com.example.web;

import com.example.pojo.*;
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

@WebServlet("*.book")
public class UserOperateServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        //去掉servlet路径中前面的/和后面的.book,只留下中间的请求类型
        String methodName = servletPath.substring(1, servletPath.length() - 5);
        System.out.println(methodName);
        try {
            //利用反射得到对应请求类型方法的信息
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //利用反射调用执行方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void updateMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        HttpSession session = req.getSession();
        session.setAttribute("bookId", bookId);
        req.getRequestDispatcher("/Pages/changeBookMsg.jsp").forward(req, resp);

    }
    //更新书本信息
    public void receiveNewMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int bookId = (int) session.getAttribute("bookId");
        //页面得到的书本信息和价格
        String msg = req.getParameter("bookMsg");
        double price = Double.parseDouble(req.getParameter("money"));
        userService.daoUpdateBook(bookId, msg, price);
        showSelfBookMsg(req, resp);
    }

    public void publishNewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        userService.daoPublish(bookId);
        showSelfBookMsg(req, resp);
        System.out.println("发布成功");
    }

    public void addBookMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int user_id = (int) session.getAttribute("userid");
        String msg = req.getParameter("newBookMsg");
        double price = Double.parseDouble(req.getParameter("price"));

        userService.addBook(user_id, msg, price);
        showSelfBookMsg(req, resp);
        System.out.println("新增书本信息成功");
    }

    public void showSelfBookMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //回到未发布的书信息页
        HttpSession session = req.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<BookMessage> bookMsg = userService.showSelfBookMsg(user_id);
        req.setAttribute("selfBookMsg", bookMsg);
        req.getRequestDispatcher("/Pages/saleInfo.jsp").forward(req, resp);
    }

    //查看别人的二手书籍
    public void lookOthersBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user_id = (int) session.getAttribute("userid");
        List<OtherBookMsg> otherBooksMsg = userService.lookOtherBook(user_id);
        req.setAttribute("otherBook", otherBooksMsg);
        req.getRequestDispatcher("/Pages/queryOtherBooks.jsp").forward(req, resp);
    }
//对书本进行留言
    public void commentBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        HttpSession session = req.getSession();
        session.setAttribute("the_book", bookId);
        req.getRequestDispatcher("/Pages/comment.jsp").forward(req, resp);
    }
//保存留言
    public void saveComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int bookId = (int) session.getAttribute("the_book");
        int user_id = (int) session.getAttribute("userid");
        String com = req.getParameter("comment");

        //调用
        userService.insertComment(bookId, user_id, com);
        lookOthersBook(req, resp);
        System.out.println("留言成功");
    }

    //回到已发布页面
    public void backPublished(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<BookMessage> bookMsg = userService.queryPublishedBookMsg(user_id);
        req.setAttribute("queryPublishedBookMsg", bookMsg);
        req.getRequestDispatcher("/Pages/selfPublished.jsp").forward(req, resp);
    }

    //查看留言
    public void queryComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user_id = (int) session.getAttribute("userid");
        List<Comment> comments = userService.queryComment(user_id);
        req.setAttribute("Comment", comments);
        req.getRequestDispatcher("/Pages/showComment.jsp").forward(req, resp);
    }

    //回复留言saveAnsComment
    public void ansComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        int comId  = Integer.parseInt(req.getParameter("com_id"));
        HttpSession session = req.getSession();
        session.setAttribute("ans_book", bookId);
        session.setAttribute("ans_com",comId);
        req.getRequestDispatcher("/Pages/ansComment.jsp").forward(req, resp);
    }

    public void saveAnsComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int bookId = (int) session.getAttribute("ans_book");
        int user_id = (int) session.getAttribute("userid");
        int comId = (int) session.getAttribute("ans_com");
        String com = req.getParameter("ansComm");

        //调用
        userService.ansComment(bookId, user_id, com, comId);
        queryComment(req, resp);
        System.out.println("回复留言成功");
    }

    //查看自己的留言回复
    public void querySelfComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userid");
        List<Replycomment> ansComments = userService.queryAnsCom(userId);
        req.setAttribute("AnsCom", ansComments);
        req.getRequestDispatcher("/Pages/queryAnsCom.jsp").forward(req, resp);
    }

    //关闭销售信息,且关闭后不可留言
    public void closeComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        userService.closeComment(bookId);
        backPublished(req, resp);
    }

    //修改用户信息
    public void changeUserMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();//创建HttpSession接口对象
        int user_id = (int) session.getAttribute("userid");//获取对象
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userService.changeUserMassage(user_id, username, password);
        req.getRequestDispatcher("/Pages/welcome.jsp").forward(req, resp);
    }
    public void userMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();//创建HttpSession接口对象
        int userId= (int) session.getAttribute("userid");//获取对象

        List<User> users = userService.UserMessage(userId);
        req.setAttribute("userMsg",users);
        req.getRequestDispatcher("/Pages/UserMessage.jsp").forward(req, resp);
    }
}
