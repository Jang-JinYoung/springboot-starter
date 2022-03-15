package com.example.springbootstarter.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.springbootstarter.mapper.Mapper;
import com.example.springbootstarter.model.Board;
import com.example.springbootstarter.model.Comment;
import com.example.springbootstarter.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
public class Service {

    @Autowired
    Mapper mapper;

    // 게시글 리스트를 가져온다.
    public ArrayList<Board> getBoardList(Board board) {
        return mapper.getBoardList(board);
    }

    // 특정 게시글을 가져온다
    public Board getBoard(int id) {
        return mapper.getBoard(id);
    }

    public int getBoardSize(Board board) {
        return mapper.getBoardSize(board);
    }

    public User getUser(User param) {
        return mapper.getUser(param);
    }

    public int writeBoard(Board board) {
        return mapper.writeBoard(board);
    }

    public ArrayList<Comment> getCommentList(HashMap<String, Object> hashMap) {
        return mapper.getCommentList(hashMap);
    }

    public int writeComment(Comment comment) {
        return mapper.writeComment(comment);
    }

    public int getCommentPaging(int board_id) {
        return mapper.getCommentPaging(board_id);
    }

    // 특정 게시글을 수정한다
    public int updateBoard(Board board) {
      return mapper.updateBoard(board);
    }

    public int deleteBoard(Board board) {
      return mapper.deleteBoard(board);
    }
}
