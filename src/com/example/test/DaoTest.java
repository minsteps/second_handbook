package com.example.test;

import com.example.dao.AdminDao;
import com.example.dao.UserDao;
import com.example.dao.impl.AdminDaoImpl;
import com.example.dao.impl.UserDaoImpl;
import com.example.service.AdminService;
import com.example.service.UserService;
import com.example.service.impl.AdminServiceImpl;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

public class DaoTest {
    UserService userService = new UserServiceImpl();
    UserDao userDao = new UserDaoImpl();
    AdminService adminService = new AdminServiceImpl();
    AdminDao adminDao = new AdminDaoImpl();
    @Test
    public void testgetAllUser(){

        System.out.println(userDao.getAllUser());
    }
    @Test
    public void testAddBook(){

        System.out.println(userService.getAllUser());
    }
    @Test
    public void testshowOneUser(){

        System.out.println(userService.showOneUser(1,"123456"));
    }
    @Test
    public void testqueryPushedbookMsg(){

        System.out.println(userService.queryPublishedBookMsg(1234));
    }
    @Test
    public void testchangeUserMassage(){

        userService.changeUserMassage(1234,"asso","12345678");
    }
    @Test
    public void testlookOtherBook(){

        System.out.println(userDao.lookOtherBook(1234));
    }
    @Test
    public void testqueryComment(){

        System.out.println(userDao.queryComment(1234));
    }
    @Test
    public void testqueryAnsComm(){

        System.out.println(userDao.queryAnsCom(1234));
    }
    @Test
    public void closeComment(){

        userDao.closeComment(12);
    }
    @Test
    public void testAdminPbMsg(){

        System.out.println(adminDao.adminPbMsg());
    }
    @Test
    public void testmangeVip(){

        System.out.println(adminDao.manageVip());
    }
    @Test
    public void testmangeUser(){

        System.out.println(adminDao.manageUser());
    }
    @Test
    public void testshowSelfBook(){

        System.out.println(userDao.showSelfBook(1234));
    }
    @Test
    public void testqueryAnsCom(){

        System.out.println(userDao.queryAnsCom(1234));
    }
    @Test
    public void testInsertComment(){
        userService.insertComment(13,1234,"哈哈哈哈");
    }
    @Test
    public void testUserMessage(){
        System.out.println(userService.UserMessage(1234));
    }
    @Test
    public void testAnsComment(){
        userDao.ansComment(1,12345,"谢谢亲",1);
    }
}
