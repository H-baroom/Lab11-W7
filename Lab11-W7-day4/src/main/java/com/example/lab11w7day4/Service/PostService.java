package com.example.lab11w7day4.Service;

import com.example.lab11w7day4.Api.ApiException;
import com.example.lab11w7day4.Model.Post;
import com.example.lab11w7day4.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Integer id,Post post) {
        Post updatePost = postRepository.findPostById(id);
        if (updatePost == null) {
            throw new ApiException("post not found");
        }
        updatePost.setCategory_id(post.getCategory_id());
        updatePost.setUser_id(post.getUser_id());
        updatePost.setTitle(post.getTitle());
        updatePost.setContent(post.getContent());
        postRepository.save(updatePost);

    }

    public void deletePost(Integer id) {
        Post deletePost = postRepository.findPostById(id);
        if (deletePost == null) {
            throw new ApiException("post not found");
        }
    }


    public List<Post> getPostByTitle(String title) {
        List<Post> titlePost = postRepository.findPostByTitle(title);
        if (titlePost.isEmpty()) {
            throw new ApiException("post not found");
        }
        return titlePost;
    }

    public List<Post> getPostByUser_idAndCategory_id(Integer user_id, Integer category_id) {
        List<Post> userAndCategory = postRepository.getPostByUser_idAndCategory_id(user_id, category_id);
        if (userAndCategory.isEmpty()) {
            throw new ApiException("post not found");
        }
        return userAndCategory;
    }

}
