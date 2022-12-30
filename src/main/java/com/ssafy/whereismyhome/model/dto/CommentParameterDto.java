package com.ssafy.whereismyhome.model.dto;

public class CommentParameterDto {
    private int pg;

    private int spp;

    private int start;

    private int board_no;

    public CommentParameterDto() {
        pg = 1;
        spp = 5;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getSpp() {
        return spp;
    }

    public void setSpp(int spp) {
        this.spp = spp;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    @Override
    public String toString() {
        return "CommentParameterDto{" +
                "pg=" + pg +
                ", spp=" + spp +
                ", start=" + start +
                ", board_no=" + board_no +
                '}';
    }
}
