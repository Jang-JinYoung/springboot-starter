package com.example.springbootstarter.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User {
    private int no;
    private String id;
    private String pw;
    private String nickname;
}
