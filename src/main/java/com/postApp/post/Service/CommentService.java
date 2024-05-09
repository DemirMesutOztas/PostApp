package com.postApp.post.Service;

import com.postApp.post.Entity.Comment;
import com.postApp.post.Entity.Post;
import com.postApp.post.Entity.User;
import com.postApp.post.Repository.CommentRepository;
import com.postApp.post.Request.CommentCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;


    public List<Comment> getAllCommentsWithparam(Optional<Integer> userId,
                                                 Optional<Integer> postId) {

        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }
        else if(userId.isPresent())
        {
            return commentRepository.findByUserId(userId.get());

        } else if (postId.isPresent())
        {
            return commentRepository.findByPostId(postId.get());

        }
        else{
            return commentRepository.findAll();
        }

    }

    public Comment getOneCommentById(Integer commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user =  userService.getOneUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePostById(commentCreateRequest.getPostId());
        if(user != null && post != null){
            Comment comment = new Comment();
            comment.setId(commentCreateRequest.getId());
            comment.setPost(post);
            comment.setUser(user);
            comment.setText(commentCreateRequest.getText());
            return commentRepository.save(comment);
        }
        else {
            return  null;
        }

    }
}
