package com.example.pojo;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private Integer vip;

    public User() {
    }

    public User(Integer user_id, String username, String password, Integer vip) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.vip = vip;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vip=" + vip +
                '}';
    }
}
