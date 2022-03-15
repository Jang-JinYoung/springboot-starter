package com.example.springbootstarter.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board")
public class Board {
    private int id;
    private String title;
    private String writer;
    private String country;
    private String text;
    private String writeDate;
    private String writeTime;
    
    
    private int page;
    private int comments; // 댓글 개수
    private String search; // 검색용
}
