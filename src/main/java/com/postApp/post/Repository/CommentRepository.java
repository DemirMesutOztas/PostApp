package com.postApp.post.Repository;

import com.postApp.post.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByUserIdAndPostId(Integer userId, Integer postId);

    List<Comment> findByUserId(Integer userId);

    List<Comment> findByPostId(Integer integer);
}
