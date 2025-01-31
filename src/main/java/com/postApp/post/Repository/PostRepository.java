package com.postApp.post.Repository;

import com.postApp.post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findByUserId(Integer userId);
}
