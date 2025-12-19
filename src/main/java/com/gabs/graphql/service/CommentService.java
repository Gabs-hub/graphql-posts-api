package com.gabs.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.gabs.graphql.repository.CommentRepository;
import com.gabs.graphql.repository.PostRepository;

import graphql.GraphQLException;

import com.gabs.graphql.model.Comment;

@Service
public class CommentService {
 
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment getCommentById(String id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment createComment(String postId, String author, String text) {

        if (!postRepository.existsById(postId)) {
            throw new GraphQLException("Post não encontrado para o id: " + postId);
        }

        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setAuthor(author);
        comment.setText(text);

        return commentRepository.save(comment);
    }


    public Comment updateComment(String id, String text) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null) {
            comment.setText(text);
            commentRepository.save(comment);
        }
        return comment;
    }

    public boolean deleteComment(String id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Comment> getAllCommentsByPostId(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }
}
