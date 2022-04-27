package com.example.dao.impl;

import com.example.dao.AdminDao;
import com.example.pojo.AdminPublished;
import com.example.pojo.User;

import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {

    @Override
    public List<AdminPublished> adminPbMsg() {
        String sql = "SELECT tb_book.book_id, tb_user.username, tb_book.msg, tb_book.price\n" +
                " from tb_book, tb_user \n" +
                " where tb_book.ban = 0 and tb_book.publish = 1 and tb_user.user_id = tb_book.user_id;";
        return fetchList(AdminPublished.class,sql);
    }

    @Override
    public void banPbMsg(int book_id) {
        String sql = "UPDATE tb_book SET ban = 1 where book_id = " + book_id +";";
        update(sql);
    }

    @Override
    public List<User> manageVip() {
        String sql = "SELECT tb_user.user_id, tb_user.password, tb_user.username , tb_user.vip from tb_user where tb_user.vip = 1;";
        return fetchList(User.class,sql);
    }
    @Override
    public List<User> manageUser() {
        String sql = "SELECT tb_user.user_id, tb_user.password, tb_user.username , tb_user.vip from tb_user where tb_user.vip = 0;";
        return fetchList(User.class,sql);
    }
    @Override
    public void closeDaoVip(int user_id) {
        String sql = "UPDATE tb_user SET vip = 0 where user_id = " + user_id +";";
        update(sql);
    }
    public void becomeVip(int user_id) {
        String sql = "UPDATE tb_user SET vip = 1 where user_id = " + user_id +";";
        update(sql);
    }
}
