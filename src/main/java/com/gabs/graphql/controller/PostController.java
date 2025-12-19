package com.gabs.graphql.controller;

import com.gabs.graphql.model.Post;
import com.gabs.graphql.service.PostService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public Post getPostById(@Argument String id) {
        return postService.getPostById(id);
    }

    @QueryMapping
    public Iterable<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String content) {
        return postService.createPost(title, content);
    }

    @MutationMapping
    public Post updatePost(@Argument String id, @Argument String title, @Argument String content) {
        return postService.updatePost(id, title, content);

    }

    @MutationMapping
    public boolean deletePost(@Argument String id) {
        return postService.deletePost(id);
    }
}
