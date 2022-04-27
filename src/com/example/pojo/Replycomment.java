package com.example.pojo;

public class Replycomment {
    private String msg;
    private double price;
    private String commName;
    private String content;
    private String replyComm;

    public Replycomment() {

    }

    public Replycomment(String msg, double price, String commName, String content, String replyComm) {
        this.msg = msg;
        this.price = price;
        this.commName = commName;
        this.content = content;
        this.replyComm = replyComm;
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

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyComm() {
        return replyComm;
    }

    public void setReplyComm(String replyComm) {
        this.replyComm = replyComm;
    }

    @Override
    public String toString() {
        return "Replycomment{" +
                "msg='" + msg + '\'' +
                ", price=" + price +
                ", commName='" + commName + '\'' +
                ", content='" + content + '\'' +
                ", replyComm='" + replyComm + '\'' +
                '}';
    }
}
