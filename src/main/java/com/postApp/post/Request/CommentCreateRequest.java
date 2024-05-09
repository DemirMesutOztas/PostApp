package com.postApp.post.Request;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private int id;
    private int postId;
    private int userId;
    private String text;
}
