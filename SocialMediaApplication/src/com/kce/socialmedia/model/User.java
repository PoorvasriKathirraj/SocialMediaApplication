package com.kce.socialmedia.model;

import java.util.ArrayList;

public class User {

    public String name;
    public int age;
    public String location;
    public String occupation;

    public ArrayList<User> friends = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();

    public User(String name,int age,String location,String occupation){
        this.name=name;
        this.age=age;
        this.location=location;
        this.occupation=occupation;
    }
}