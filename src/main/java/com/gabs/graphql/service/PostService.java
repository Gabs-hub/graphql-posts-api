package com.gabs.graphql.service;
import com.gabs.graphql.repository.PostRepository;
import com.gabs.graphql.repository.CommentRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabs.graphql.model.Comment;
import com.gabs.graphql.model.Post;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Post createPost(String title, String content) {
        Post post = new Post(null, title, content);
        return postRepository.save(post);
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post updatePost(String id, String title, String content) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
            return postRepository.save(post);
        }
        return post;
    }

    public boolean deletePost(String id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            List<Comment> comments = commentRepository.findByPostId(id);
            for (Comment comment : comments) {
                commentRepository.deleteById(comment.getId());
            }
            return true;
        }
        return false;
    }
}
