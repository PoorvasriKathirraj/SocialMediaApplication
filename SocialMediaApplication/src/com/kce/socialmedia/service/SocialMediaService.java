package com.kce.socialmedia.service;

import java.util.Scanner;
import com.kce.socialmedia.model.*;
import com.kce.socialmedia.util.DataStore;

public class SocialMediaService {

    public void signup(Scanner sc){

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Occupation: ");
        String occupation = sc.nextLine();

        User user = new User(name,age,location,occupation);

        DataStore.users.add(user);

        System.out.println("User Registered Successfully!");
    }

    public void sendFriendRequest(Scanner sc){

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Friend Name: ");
        String friendName = sc.nextLine();

        User u1 = findUser(name);
        User u2 = findUser(friendName);

        if(u1 == null || u2 == null){
            System.out.println("User not found! Please signup first.");
            return;
        }

        u1.friends.add(u2);
        u2.friends.add(u1);

        System.out.println("Friend Added Successfully!");
    }

    public void viewFriends(Scanner sc){

        System.out.print("Enter Username: ");
        String name = sc.nextLine();

        User user = findUser(name);

        if(user == null){
            System.out.println("User not found!");
            return;
        }

        if(user.friends.isEmpty()){
            System.out.println("No friends yet.");
            return;
        }

        System.out.println("\nFriends List:");

        for(User f : user.friends){
            System.out.println(f.name+" | "+f.age+" | "+f.location+" | "+f.occupation);
        }
    }

    public void createPost(Scanner sc){

        System.out.print("Enter Username: ");
        String name = sc.nextLine();

        User user = findUser(name);

        if(user == null){
            System.out.println("User not found! Please signup first.");
            return;
        }

        System.out.print("Enter Post: ");
        String postContent = sc.nextLine();

        Post post = new Post(name, postContent);

        user.posts.add(post);

        System.out.println("Post Created Successfully!");
    }

    public void viewFeed(Scanner sc){

        System.out.print("Enter Username: ");
        String name = sc.nextLine();

        User user = findUser(name);

        if(user == null){
            System.out.println("User not found!");
            return;
        }

        System.out.println("\n---- News Feed ----");

        for(User f : user.friends){

            for(Post p : f.posts){

                System.out.println("\nAuthor: " + p.author);
                System.out.println("Post: " + p.content);
                System.out.println("Likes: " + p.likes);

                for(String c : p.comments){
                    System.out.println("Comment: " + c);
                }
            }
        }
    }

    private User findUser(String name){

        for(User u : DataStore.users){

            if(u.name.equalsIgnoreCase(name)){
                return u;
            }
        }

        return null;
    }
}