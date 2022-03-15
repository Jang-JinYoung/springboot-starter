package com.example.springbootstarter.controller;

import com.example.springbootstarter.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootstarter.model.Result;
import com.example.springbootstarter.model.User;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.springbootstarter.model.Board;
import com.example.springbootstarter.model.Comment;


@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }

    // 로그인 정보를 가져온다
    @PostMapping("/auth")
    public Result Login(@RequestBody User param) {
        Result result = new Result();
        User user = service.getUser(param);

        if(user == null) {
            result.setData("fail");
        } else {
            result.setData(user);
        }
        return result;
    }

    // 게시판 리스트 사이즈를 가져온다
    @PostMapping("/boardSize")
    public Result getBoardSize(@RequestBody Board board) {
        Result result = new Result();
        int boardSize = service.getBoardSize(board);

        result.setData(boardSize);
        return result;
    }

    // 게시판 리스트를 가져온다.
    @PostMapping("/boardList")
    public Result getBoardList(@RequestBody Board board) {
        Result result = new Result();

        // 한번에 받아올 개시글 개수, 현재 10개
        board.setPage((board.getPage()-1)*10);
        
        ArrayList<Board> boardList = service.getBoardList(board);

        result.setData(boardList);
        return result;
    }

    // 특정 게시글을 가져온다.
    @PostMapping("/board")
    public Result getBoard(@RequestBody Board board) {
        Result result = new Result();
        Board detailBoard = service.getBoard(board.getId());

        result.setData(detailBoard);
        return result;
    }

    // 게시글을 작성한다.
    @PostMapping("/write")
    public void writeBoard(@RequestBody Board board) {
        service.writeBoard(board);
    }

    // 댓글 페이징을 가져온다.
    @PostMapping("/comment/paging")
    public Result getCommentPaging(@RequestBody Comment comment) {
        Result result = new Result();
        int paging = service.getCommentPaging(comment.getBoard_id());

        result.setData(paging);
        return result;
    }

    // 댓글을 가져온다.
    @GetMapping("/comment/list")
    public Result getComment(@RequestParam(value = "id") int board_id,
                             @RequestParam(value = "page") int page) {

        Result result = new Result();
        page = (page-1)*10;

        HashMap<String, Object> HashMap = new HashMap<String, Object>();
        HashMap.put("board_id", board_id);
        HashMap.put("page", page);

        ArrayList<Comment> commentList = service.getCommentList(HashMap);

        result.setData(commentList);
        return result;
    }

    // 댓글을 작성한다
    @PostMapping("/comment/write")
    public int writeComment(@RequestBody Comment comment) {
        int result = service.writeComment(comment);

        return result;
    }

    // 게시글을 수정한다
    @PostMapping("/update")
    public int updateBoard(@RequestBody Board board) {
        int result = service.updateBoard(board);
        return result;
    }

    //게시글을 삭제한다
    @PostMapping("/delete")
    public int deleteBoard(@RequestBody Board board) {
        int result = service.deleteBoard(board);
        return result;
    }

}
