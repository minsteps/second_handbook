package com.example.dao;

import com.example.pojo.*;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();//获取全部会员信息

    boolean getOneUser(int user_id, String password);//判断是否登录的账户信息是否正确

    boolean register(int user_id, String username, String password);//判断是否注册，没有就注册

    List<BookMessage> showSelfBook(int user_id);//用于查看自己书本的信息

    List<BookMessage> queryPublishedBook(int user_id);//用于查看自己已经发布的书信息

    void daoUpdateBook(int book_id, String newMsg, double newPrice);//编辑未发布的书的信息

    void daoPublish(int book_id);//发布二手书

    void addBook(int user_id, String msg, double price);//新增二手书

    List<OtherBookMsg> lookOtherBook(int user_id);//查询别人发布的二手书

    public void insertComment(int book_id, int user_id, String content);//留言

    List<Comment> queryComment(int user_id);//查询评论

    public void ansComment(int book_id, int user_id, String replyComm, int com_id);//回复留言

    List<Replycomment> queryAnsCom(int user_id);//查看自己的回复

    void closeComment(int book_id);//关闭销售信息/留言

    void changeUserMassage(int user_id, String username, String password);//改变会员的信息

    List<User> queryUserMassage(int user_id);//查询用户名
}