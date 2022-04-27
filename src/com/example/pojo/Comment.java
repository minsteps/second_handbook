package com.example.pojo;

public class Comment {
    private Integer bookId;
    private String msg;
    private String content;
    private Integer commenterId;
    private Integer selfUserId;
    private String commenterName;
    private Integer comId;

    public Comment() {
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Comment(Integer bookId, String msg, String content, Integer commenterId, Integer selfUserId, String commenterName, Integer comId) {
        this.bookId = bookId;
        this.msg = msg;
        this.content = content;
        this.commenterId = commenterId;
        this.selfUserId = selfUserId;
        this.commenterName = commenterName;
        this.comId = comId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(Integer commenterId) {
        this.commenterId = commenterId;
    }

    public Integer getSelfUserId() {
        return selfUserId;
    }

    public void setSelfUserId(Integer selfUserId) {
        this.selfUserId = selfUserId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "bookId=" + bookId +
                ", msg='" + msg + '\'' +
                ", content='" + content + '\'' +
                ", commenterId=" + commenterId +
                ", selfUserId=" + selfUserId +
                ", commenterName='" + commenterName + '\'' +
                ", comId=" + comId +
                '}';
    }
}
