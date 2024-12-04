package com.example.lab11w7day4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Positive(message = "not valid category id")
    @Column(columnDefinition = "int not null")
    private Integer category_id;
    @Positive(message = "not valid user id")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @NotEmpty(message = "not valid title")
    @Column(columnDefinition = "varchar(23) not null")
    private String title;
    @NotEmpty(message = "not valid content")
    @Column(columnDefinition = "varchar(200) not null")
    private String content;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDate publishDate = LocalDate.now();

    public Post(Integer id, Integer category_id, Integer user_id, String title, String content, LocalDate publishDate) {
        this.id = id;
        this.category_id = category_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
    }
    public Post() {}

    public Post(Integer id, Integer category_id, Integer user_id, String title, String content) {
        this.id = id;
        this.category_id = category_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }

    public Post(Integer category_id, Integer user_id, String title, String content) {
        this.category_id = category_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @Positive(message = "not valid category id") Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(@Positive(message = "not valid category id") Integer category_id) {
        this.category_id = category_id;
    }

    public @Positive(message = "not valid user id") Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(@Positive(message = "not valid user id") Integer user_id) {
        this.user_id = user_id;
    }

    public @NotEmpty(message = "not valid title") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "not valid title") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "not valid content") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "not valid content") String content) {
        this.content = content;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
