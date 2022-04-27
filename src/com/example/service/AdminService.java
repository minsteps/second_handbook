package com.example.service;

import com.example.pojo.AdminPublished;
import com.example.pojo.User;

import java.util.List;

public interface AdminService {
    List<AdminPublished> adminPbMsg();//管理员查看管理已发布

    void banPbMsg(int book_id);//屏蔽虚假消息

    List<User> manageVip();//管理员查看会员

    void closeDaoVip(int user_id);//取消会员VIP
}
