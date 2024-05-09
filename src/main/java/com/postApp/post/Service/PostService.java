package com.postApp.post.Service;

import com.postApp.post.Entity.Post;
import com.postApp.post.Entity.User;
import com.postApp.post.Repository.PostRepository;
import com.postApp.post.Request.PostCreateRequest;
import com.postApp.post.Request.PostUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    public List<Post> getAllPosts(Optional<Integer> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        else {
            return null;
        }

    }

    public Post getOnePostById(int invoiceId) {
        return postRepository.findById(invoiceId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
       User user = userService.getOneUser(newPostRequest.getUserId());
       if(user == null){
           return null;
       }
       Post post = new Post();
       post.setId(newPostRequest.getId());
       post.setText(newPostRequest.getText());
       post.setTitle(newPostRequest.getTitle());
       post.setUser(user);

        return postRepository.save(post);
    }

    public Post updateOnePostById(int postId,
                                     PostUpdateRequest postUpdateRequest) {

        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post updatePost = post.get();
            updatePost.setText(updatePost.getText());
            updatePost.setTitle(updatePost.getTitle());
            postRepository.save(updatePost);
            return updatePost;
        }

        return null;

    }

    public void deleteOnePostById(int postId) {
        postRepository.deleteById(postId);
    }
}

