package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.*;
import com.example.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> getAllUser(){
        String sql ="SELECT user_id, username, password, vip from tb_user;";
        return fetchList(User.class,sql);
    }
    @Override
    public boolean register(int user_id,String username,String password){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * from tb_user where user_id =" + user_id + ";";
        boolean registerFlag = false;

        try {//先看看有没有已经注册过的账号
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();

            if (rs.next()) registerFlag = false;
            else {
                registerFlag = true;
                String Sql2 = "insert into tb_user(user_id,username,password,vip) values (?,?,?,1);";//注册即为vip
                queryRunner.update(conn, Sql2, user_id, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }
        return registerFlag;
    }
    @Override
    public boolean getOneUser(int user_id, String password) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean loginFlag = false;
        String sql = "SELECT password from tb_user where user_id = " + user_id + ";";

        try {
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();

            if (rs.next()) {
                String psw = rs.getString("password");
                if (psw.equals(password)) {
                    loginFlag = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }
        return loginFlag;
    }
    @Override
    public List<BookMessage> showSelfBook(int user_id){

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<BookMessage> bookMsg = new ArrayList<>();
        String sql ="SELECT tb_book.book_id, tb_book.user_id, tb_book.msg,tb_book.price, " +
                "tb_user.username bookOwner, tb_book.publish , tb_book.close_com isCloseComm, tb_book.ban isBan from tb_book, tb_user " +
                "where tb_book.ban = 0 and tb_user.user_id = tb_book.user_id and tb_book.publish = 0 and tb_user.user_id = " + user_id + ";";

        try {
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql);
            rs= statement.executeQuery();

            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String msg = rs.getString("msg");
                double price = rs.getDouble("price");
                String username = rs.getString("bookOwner");
                int publish = rs.getInt("publish");
                String publishMsg;
                if (publish == 0) publishMsg = "未发布";
                else publishMsg = "已发布";
                int close_com = rs.getInt("isCloseComm");
                int ban = rs.getInt("isBan");

                bookMsg.add(new BookMessage(book_id, user_id, msg, price, username, publishMsg, close_com, ban));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }
        return bookMsg;
    }

    @Override
    public List<BookMessage> queryPublishedBook(int user_id){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<BookMessage> bookMsg = new ArrayList<>();
        String sql ="SELECT tb_book.book_id, tb_book.user_id, tb_book.msg ,tb_book.price, tb_user.username bookOwner, tb_book.publish, tb_book.close_com isCloseComm, tb_book.ban isBan \n" +
                "from tb_book,tb_user\n" +
                "where tb_user.user_id = tb_book.user_id and tb_book.publish = 1 and tb_book.ban = 0 and tb_user.vip = 1 and tb_user.user_id =" + user_id + ";";

        try {
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql);
            rs= statement.executeQuery();

            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String msg = rs.getString("msg");
                double price = rs.getDouble("price");
                String username = rs.getString("bookOwner");
                int publish = rs.getInt("publish");
                String publishMsg;
                if (publish == 0) publishMsg = "未发布";
                else publishMsg = "已发布";
                int close_com = rs.getInt("isCloseComm");
                int ban = rs.getInt("isBan");

                bookMsg.add(new BookMessage(book_id, user_id, msg, price, username, publishMsg, close_com, ban));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }
        return bookMsg;

    }
    @Override
    public void daoUpdateBook(int book_id, String newMsg, double newPrice) {
        String sql = "UPDATE tb_book SET msg = ?, price = ? where book_id = ?;";
        update(sql,newMsg,newPrice,book_id);
    }

    @Override
    public void daoPublish(int book_id) {
        String sql = "UPDATE tb_book SET publish=1 where book_id = ?;";
        update(sql,book_id);
    }

    @Override
    public void addBook(int user_id, String msg, double price){
        String sql1 = "SELECT COUNT(book_id) as num from tb_book;";
        String sql2 = "INSERT INTO tb_book VALUES (?, ?, ?, ?, 0, 0, 0);";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql1);
            rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("num");
                update(sql2,count+1,user_id,msg,price);
            }
            BaseDao.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }
    }

    @Override
    public List<OtherBookMsg> lookOtherBook(int user_id) {
        String sql = "SELECT tb_book.book_id bookId, tb_book.msg,tb_book.price, tb_user.username bookOwner\n" +
                "from tb_book, tb_user \n" +
                "where tb_user.user_id = tb_book.user_id and tb_book.publish = 1 and tb_book.close_com = 0  and tb_book.ban = 0 and tb_user.vip = 1 and tb_user.user_id != " + user_id + " ;";
        return  fetchList(OtherBookMsg.class,sql);
    }

    @Override
    public void insertComment(int book_id, int user_id, String content) {
        String sql1 = "SELECT COUNT(com_id) as num from tb_comment;";
        String sql2 = "INSERT INTO tb_comment VALUES (?, ?, ?, ?, ?);";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql1);
            rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("num");
                System.out.println(count + book_id + content + user_id);
                update(sql2,count+1,book_id,content,user_id,count+1);
            }
            BaseDao.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }

    }

    @Override
    public List<Comment> queryComment(int user_id) {
        String sql = "SELECT tb_book.book_id bookId, tb_book.msg, tb_comment.com_text content,tb_user.user_id commenterId, tb_book.user_id selfUserId, tb_user.username commenterName,tb_comment.com_id comId\n" +
                "from tb_book, tb_user, tb_comment\n" +
                "where tb_book.book_id = tb_comment.book_id and tb_comment.user_id = tb_user.user_id and tb_book.user_id = " + user_id +";";
        return fetchList(Comment.class,sql);
    }

    @Override
    public void ansComment(int book_id, int user_id, String replyComm,int com_id) {
        String sql1 = "SELECT COUNT(ans_id) as num from tb_answer;";
        String sql2 = "INSERT INTO tb_answer VALUES (?, ?, ?, ?, ?,1);";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            statement = conn.prepareStatement(sql1);
            rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("num");
                System.out.println(count + book_id + replyComm + user_id + com_id);
                update(sql2,count+1,book_id,replyComm,user_id,com_id);
            }
            BaseDao.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs,statement,conn);
        }
    }

    @Override
    public List<Replycomment> queryAnsCom(int user_id) {
        String sql ="SELECT tb_book.msg, tb_book.price, tb_user.username commName, tb_comment.com_text content, tb_answer.com_text replyComm\n" +
                "from tb_user, tb_book, tb_comment, tb_answer\n" +
                "where tb_book.book_id = tb_comment.book_id and tb_comment.book_id = tb_answer.book_id and tb_answer.com_id = tb_comment.com_id and tb_comment.user_id = tb_user.user_id and tb_answer.user_id = "+ user_id +";";
        return fetchList(Replycomment.class,sql);
    }

    @Override
    public void closeComment(int book_id) {
        String sql = "UPDATE tb_book SET close_com = 1, publish = 0 where book_id = ?;";
        update(sql,book_id);
    }

    @Override
    public void changeUserMassage(int user_id, String username, String password){
        String sql = "UPDATE tb_user SET username = ?, password = ? where user_id = ?;";
        update(sql,username,password,user_id);
    }

    @Override
    public List<User> queryUserMassage(int user_id){
        String sql ="SELECT user_id,username,password, vip from tb_user where user_id = ?;";
        return fetchList(User.class,sql,user_id);
    }
}
