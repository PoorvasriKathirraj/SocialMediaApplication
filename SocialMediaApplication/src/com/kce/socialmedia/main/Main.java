package com.kce.socialmedia.main;

import java.util.Scanner;
import com.kce.socialmedia.service.SocialMediaService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SocialMediaService service = new SocialMediaService();

        while(true){

            System.out.println("\n---- Social Media Menu ----");
            System.out.println("1. Signup");
            System.out.println("2. Send Friend Request");
            System.out.println("3. View Friends");
            System.out.println("4. Create Post");
            System.out.println("5. View News Feed");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    service.signup(sc);
                    break;

                case 2:
                    service.sendFriendRequest(sc);
                    break;

                case 3:
                    service.viewFriends(sc);
                    break;

                case 4:
                    service.createPost(sc);
                    break;

                case 5:
                    service.viewFeed(sc);
                    break;

                case 6:
                    System.out.println("Exiting Application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}