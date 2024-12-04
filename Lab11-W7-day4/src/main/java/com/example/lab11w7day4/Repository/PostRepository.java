package com.example.lab11w7day4.Repository;

import com.example.lab11w7day4.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostById(Integer id);

    List<Post> findPostByTitle(String title);

    @Query("select p from Post p where p.user_id=?1 and p.category_id=?2")
    List<Post> getPostByUser_idAndCategory_id(Integer user_id, Integer category_id);
}
