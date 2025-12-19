package com.gabs.graphql.resolver;

import com.gabs.graphql.model.Comment;
import com.gabs.graphql.model.Post;
import com.gabs.graphql.service.CommentService;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import java.util.Collection;
import java.util.List;

@Controller
public class PostResolver {

    private final CommentService commentService;

    public PostResolver(CommentService commentService) {
        this.commentService = commentService;
    }

    @SchemaMapping(typeName = "Post", field = "comments")
    public Collection<Comment> comments(Post post) {
        List<Comment> result = commentService.getAllCommentsByPostId(post.getId());
        return result;
    }
}
