package com.postApp.post.Controller;

import com.postApp.post.Entity.Post;
import com.postApp.post.Request.PostCreateRequest;
import com.postApp.post.Request.PostUpdateRequest;
import com.postApp.post.Service.PostService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/posts")
@AllArgsConstructor
@Data
public class PostController {
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Integer> userId){

        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable int postId){

        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOneInvoice(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping(path = "/{postId}")
    public Post updateOneInvoice(@PathVariable int postId,
                                 @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePostById(postId, postUpdateRequest);
    }

    @DeleteMapping(path = "/{postId}")
    public void deleteOneInvoice(@PathVariable int postId) {

        postService.deleteOnePostById(postId);
    }

}



