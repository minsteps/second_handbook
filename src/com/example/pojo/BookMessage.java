package com.example.pojo;

public class BookMessage {
    private Integer book_id;
    private Integer user_id;
    private String msg;
    private double price;
    private String bookOwner;
    private String publish;
    private Integer isCloseComm;
    private Integer isBan;

    public BookMessage() {
    }

    public BookMessage(Integer book_id, Integer user_id, String msg, double price, String bookOwner, String publish, Integer isCloseComm, Integer isBan) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.msg = msg;
        this.price = price;
        this.bookOwner = bookOwner;
        this.publish = publish;
        this.isCloseComm = isCloseComm;
        this.isBan = isBan;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getIsCloseComm() {
        return isCloseComm;
    }

    public void setIsCloseComm(Integer isCloseComm) {
        this.isCloseComm = isCloseComm;
    }

    public Integer getIsBan() {
        return isBan;
    }

    public void setIsBan(Integer isBan) {
        this.isBan = isBan;
    }

    @Override
    public String toString() {
        return "BookMsg{" +
                "book_id=" + book_id +
                ", user_id=" + user_id +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                ", bookOwner='" + bookOwner + '\'' +
                ", publish='" + publish + '\'' +
                ", isCloseComm=" + isCloseComm +
                ", isBan=" + isBan +
                '}';
    }
}
