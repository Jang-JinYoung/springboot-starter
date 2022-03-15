package com.example.springbootstarter.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("comment")
public class Comment{

    private int board_id;
    private String text;
    private String nickname;
    
}
