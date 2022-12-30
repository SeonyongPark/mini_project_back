package com.ssafy.whereismyhome.model.dto;

public class CommentDTO {
    private int comment_id;
    private int board_no;
    private String user_id;
    private String register_date;
    private  String content;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "comment_id=" + comment_id +
                ", board_no=" + board_no +
                ", user_id='" + user_id + '\'' +
                ", register_date='" + register_date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
