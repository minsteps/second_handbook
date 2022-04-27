package com.example.dao;

import com.example.pojo.AdminPublished;
import com.example.pojo.User;

import java.util.List;

public interface AdminDao {

    List<AdminPublished> adminPbMsg();//管理员查看管理已发布

    void banPbMsg(int book_id);//屏蔽虚假消息

    List<User> manageVip();//管理员查看会员

    List<User> manageUser() ;//查看不是会员的用户

    void closeDaoVip(int user_id);//取消会员VIP

    void becomeVip(int user_id);//升级为vip
}
