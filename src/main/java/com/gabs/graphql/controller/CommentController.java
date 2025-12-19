package com.gabs.graphql.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.gabs.graphql.model.Comment;
import com.gabs.graphql.service.CommentService;

@Controller
public class CommentController {
    
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @QueryMapping
    public Iterable<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @QueryMapping
    public Comment getCommentById(@Argument String id) {
        return commentService.getCommentById(id);
    }

    @MutationMapping
    public Comment createComment(@Argument String postId, @Argument String author, @Argument String text) {
        return commentService.createComment(postId, author, text);
    }

    @MutationMapping
    public Comment updateComment(@Argument String id, @Argument String text) {
        return commentService.updateComment(id, text);
    }

    @MutationMapping
    public boolean deleteComment(@Argument String id) {
        return commentService.deleteComment(id);
    }
}
