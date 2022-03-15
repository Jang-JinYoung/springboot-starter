package com.example.springbootstarter.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.springbootstarter.model.Board;
import com.example.springbootstarter.model.Comment;
import com.example.springbootstarter.model.User;

import org.springframework.stereotype.Repository;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    // 로그인 mapper
    User getUser(User param);

    // 게시판 리스트 가져오는 mapper
    ArrayList<Board> getBoardList(Board board);

    // 특정 게시글 가져오는 mapper
    Board getBoard(int id);

    // 페이징 mapper
    int getBoardSize(Board board);

    // 게시글 작성하는 mapper
    int writeBoard(Board board);

    // 댓글 가져오는 mapper
    ArrayList<Comment> getCommentList(HashMap<String, Object> hashMap);

    // 댓글 작성하는 mapper
    int writeComment(Comment comment);

    // 댓글 페이징 mapper
    int getCommentPaging(int board_id);

    // 게시글 업데이트
    int updateBoard(Board board);

    // 게시글 삭제
    int deleteBoard(Board board);

}
