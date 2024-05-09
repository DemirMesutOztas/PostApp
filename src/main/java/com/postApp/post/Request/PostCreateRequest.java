package com.postApp.post.Request;

import lombok.Data;

import java.sql.Date;

@Data
public class PostCreateRequest {
    int id;
    String text;
    String title;
    int userId;
}
