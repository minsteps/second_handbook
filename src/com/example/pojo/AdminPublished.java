package com.example.pojo;

public class AdminPublished {
    private Integer book_id;
    private String username;
    private String msg;
    private double price;

    public AdminPublished() {
    }

    public AdminPublished(Integer book_id, String username, String msg, double price) {
        this.book_id = book_id;
        this.username = username;
        this.msg = msg;
        this.price = price;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AdminPublished{" +
                "book_id=" + book_id +
                ", username='" + username + '\'' +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                '}';
    }
}
