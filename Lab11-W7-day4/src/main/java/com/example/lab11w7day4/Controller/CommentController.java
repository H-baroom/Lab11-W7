package com.example.lab11w7day4.Controller;

import com.example.lab11w7day4.Api.ApiResponse;
import com.example.lab11w7day4.Model.Comment;
import com.example.lab11w7day4.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllComments() {
        return ResponseEntity.status(200).body(commentService.getAllComments());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("comment deleted"));
    }

    @GetMapping("/getCommentByUser_id/{user_id}")
    public ResponseEntity getCommentByUser_id(@PathVariable Integer user_id) {
        List<Comment> comments = commentService.getCommentByUser_id(user_id);
        return ResponseEntity.status(200).body(comments);
    }

    @GetMapping("/getCommentByPostId/{post_id}")
    public ResponseEntity getCommentByPostId(@PathVariable Integer post_id) {
        List<Comment> comments = commentService.getCommentByPost_id(post_id);
        return ResponseEntity.status(200).body(comments);
    }
}
