package com.example.lab11w7day4.Service;

import com.example.lab11w7day4.Api.ApiException;
import com.example.lab11w7day4.Model.Comment;
import com.example.lab11w7day4.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Integer id,Comment comment) {
        Comment updateComment = commentRepository.findCommentById(id);
        if (updateComment == null) {
            throw new ApiException("Comment not found");
        }
        updateComment.setContent(comment.getContent());
        updateComment.setPost_id(comment.getPost_id());
        updateComment.setUser_id(comment.getUser_id());
        commentRepository.save(updateComment);
    }
    public void deleteComment(Integer id) {
        Comment comment = commentRepository.findCommentById(id);
        if (comment == null) {
            throw new ApiException("Comment not found");
        }
        commentRepository.delete(comment);
    }

    public List<Comment> getCommentByUser_id(Integer user_id) {
        List<Comment> commentsByUser = commentRepository.findAllByUser_id(user_id);
        if (commentsByUser.isEmpty()) {
            throw new ApiException("No comments found");
        }
        return commentsByUser;
    }

    public List<Comment> getCommentByPost_id(Integer post_id) {
        List<Comment> commentsByPostId = commentRepository.findAllByPostId(post_id);
        if (commentsByPostId.isEmpty()) {
            throw new ApiException("No comments found");
        }
        return commentsByPostId;
    }

}
