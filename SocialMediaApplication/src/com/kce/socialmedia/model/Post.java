package com.kce.socialmedia.model;

import java.util.ArrayList;

public class Post {

    public String content;
    public String author;
    public int likes=0;

    public ArrayList<String> comments = new ArrayList<>();

    public Post(String author,String content){
        this.author=author;
        this.content=content;
    }
}