package com.example.pojo;

public class OtherBookMsg {
    private Integer bookId;
    private String msg;
    private double price;
    private String bookOwner;

    public OtherBookMsg() {
    }

    public OtherBookMsg(Integer bookId, String msg, double price, String bookOwner) {
        this.bookId = bookId;
        this.msg = msg;
        this.price = price;
        this.bookOwner = bookOwner;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    public String getBookOwner() {
        return bookOwner;
    }

    public void setBookOwner(String bookOwner) {
        this.bookOwner = bookOwner;
    }

    @Override
    public String toString() {
        return "OtherBookMsg{" +
                "bookId=" + bookId +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                ", bookOwner='" + bookOwner + '\'' +
                '}';
    }
}
