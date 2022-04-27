package com.example.service.impl;

import com.example.dao.AdminDao;
import com.example.dao.impl.AdminDaoImpl;
import com.example.pojo.AdminPublished;
import com.example.pojo.User;
import com.example.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public List<AdminPublished> adminPbMsg() {
        return adminDao.adminPbMsg();
    }

    @Override
    public void banPbMsg(int book_id) {
        adminDao.banPbMsg(book_id);
    }

    @Override
    public List<User> manageVip() {
        return adminDao.manageVip();
    }

    @Override
    public void closeDaoVip(int user_id) {
        adminDao.closeDaoVip(user_id);
    }
}
