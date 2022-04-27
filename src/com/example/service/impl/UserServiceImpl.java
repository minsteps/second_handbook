package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.*;
import com.example.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public boolean showOneUser(int user_id, String password) {
        return userDao.getOneUser(user_id,password);
    }

    @Override
    public boolean registerUser(int user_id, String username, String password) {
        return userDao.register(user_id,username,password);
    }

    @Override
    public List<BookMessage> showSelfBookMsg(int user_id) {
        return userDao.showSelfBook(user_id);
    }

    @Override
    public List<BookMessage> queryPublishedBookMsg(int user_id) {
        return userDao.queryPublishedBook(user_id);
    }

    @Override
    public void daoUpdateBook(int book_id, String newMsg, double newPrice) {
        userDao.daoUpdateBook(book_id,newMsg,newPrice);
    }

    @Override
    public void daoPublish(int book_id){
        userDao.daoPublish(book_id);
    }

    @Override
    public void addBook(int user_id, String msg, double price){
        userDao.addBook(user_id,msg,price);
    }

    @Override
    public List<OtherBookMsg> lookOtherBook(int user_id) {
        return userDao.lookOtherBook(user_id);
    }

    @Override
    public void insertComment(int book_id, int user_id, String content) {
        userDao.insertComment(book_id,user_id,content);
    }

    @Override
    public List<Comment> queryComment(int user_id) {
        return userDao.queryComment(user_id);
    }

    @Override
    public void ansComment(int book_id, int user_id, String replyComm,int com_id){
        userDao.ansComment(book_id,user_id,replyComm,com_id);
    }

    @Override
    public List<Replycomment> queryAnsCom(int user_id) {
        return userDao.queryAnsCom(user_id);
    }

    @Override
    public void closeComment(int book_id) {
        userDao.closeComment(book_id);
    }

    @Override
    public void changeUserMassage(int user_id, String username, String password) {
        userDao.changeUserMassage(user_id,username,password);
    }

    @Override
    public List<User> UserMessage(int user_id){
        return userDao.queryUserMassage(user_id);
    }
}
