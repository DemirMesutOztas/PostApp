package com.postApp.post.Request;

import lombok.Data;

import java.sql.Date;

@Data
public class PostUpdateRequest {

    String title;
    String text;

}
