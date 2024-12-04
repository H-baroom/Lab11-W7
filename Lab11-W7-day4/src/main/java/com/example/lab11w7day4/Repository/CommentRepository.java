package com.example.lab11w7day4.Repository;

import com.example.lab11w7day4.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentById(Integer id);

    @Query("select c from Comment c where c.user_id=?1")
    List<Comment> findAllByUser_id(Integer id);

    @Query("select c from Comment c where c.post_id=?1")
    List<Comment> findAllByPostId(Integer id);
}
