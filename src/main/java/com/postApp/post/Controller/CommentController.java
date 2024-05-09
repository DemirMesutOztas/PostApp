package com.postApp.post.Controller;

import com.postApp.post.Entity.Comment;
import com.postApp.post.Request.CommentCreateRequest;
import com.postApp.post.Service.CommentService;
import com.postApp.post.Service.PostService;
import com.postApp.post.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/comments")
@Data
@AllArgsConstructor
@RestController
public class CommentController {
    private CommentService commentService;


    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Integer> userId,
                                        @RequestParam Optional<Integer> postId){

        return commentService.getAllCommentsWithparam(userId,postId);


    }
    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Integer commentId){
        return commentService.getOneCommentById(commentId);

    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createOneComment(commentCreateRequest);
    }
}
