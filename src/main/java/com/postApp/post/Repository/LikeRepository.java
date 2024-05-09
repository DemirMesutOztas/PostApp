package com.postApp.post.Repository;

import com.postApp.post.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Integer> {
}
