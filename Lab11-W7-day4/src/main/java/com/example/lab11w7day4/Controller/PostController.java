package com.example.lab11w7day4.Controller;

import com.example.lab11w7day4.Api.ApiResponse;
import com.example.lab11w7day4.Model.Post;
import com.example.lab11w7day4.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllPosts() {
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("post added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body(new ApiResponse("post updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body(new ApiResponse("post deleted"));
    }

    @GetMapping("/getPostByTitle/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        return ResponseEntity.ok().body(postService.getPostByTitle(title));
    }

    @GetMapping("/getPostByUser_idAndCategory_id/{user_id}/{category_id}")
    public ResponseEntity getPostByUser_idAndCategory_id(@PathVariable Integer user_id, @PathVariable Integer category_id) {
        List<Post> posts = postService.getPostByUser_idAndCategory_id(user_id, category_id);
        return ResponseEntity.status(200).body(posts);
    }
}
