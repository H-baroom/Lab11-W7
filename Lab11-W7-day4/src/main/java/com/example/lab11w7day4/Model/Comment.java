package com.example.lab11w7day4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Positive(message = "not valid user id")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @Positive(message = "not valid post id")
    @Column(columnDefinition = "int not null")
    private Integer post_id;
    @NotEmpty(message = "not valid content")
    @Column(columnDefinition = "varchar(150) not null")
    private String content;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDate comment_date = LocalDate.now();


    public Comment(Integer id, Integer user_id, Integer post_id, String content) {
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
    }
    public Comment(){}
    public Comment(Integer id, Integer user_id, Integer post_id, String content, LocalDate comment_date) {
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
        this.comment_date = comment_date;
    }

    public Comment(Integer user_id, Integer post_id, String content) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @Positive(message = "not valid user id") Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(@Positive(message = "not valid user id") Integer user_id) {
        this.user_id = user_id;
    }

    public @Positive(message = "not valid post id") Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(@Positive(message = "not valid post id") Integer post_id) {
        this.post_id = post_id;
    }

    public @NotEmpty(message = "not valid content") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "not valid content") String content) {
        this.content = content;
    }

    public LocalDate getComment_date() {
        return comment_date;
    }

    public void setComment_date(LocalDate comment_date) {
        this.comment_date = comment_date;
    }
}
