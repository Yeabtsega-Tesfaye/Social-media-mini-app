package com.Habeshagram;

import java.util.List;
import java.util.Scanner;

public class Main {
    private List<User> users;
    private User currentUser;
    private Scanner scanner;
    
    public Main() {
        this.users = SimpleDataManager.loadData();
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        
        while (true) {
            if (currentUser == null) {
                showMainMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private void exitApp() {
        SimpleDataManager.saveData(users); // Changed to SimpleDataManager
        System.out.println("Data saved. Goodbye!");
        System.exit(0);
    }
    
    private void showMainMenu() {
        System.out.println("\t _   _       _               _                                      \r\n" + //
                        "\t| | | | __ _| |__   ___  ___| |__   __ _  __ _ _ __ __ _ _ __ ___   \r\n" + //
                        "\t| |_| |/ _` | '_ \\ / _ \\/ __| '_ \\ / _` |/ _` | '__/ _` | '_ ` _ \\  \r\n" + //
                        "\t|  _  | (_| | |_) |  __/\\__ \\ | | | (_| | (_| | | | (_| | | | | | | \r\n" + //
                        "\t|_| |_|\\__,_|_.__/ \\___||___/_| |_|\\__,_|\\__, |_|  \\__,_|_| |_| |_| \r\n" + //
                        "\t                                         |___/                      ");
        System.out.println("\t\t\t==================================");
        System.out.println("\t\t\t     WELCOME TO HABESHAGRAM!      ");
        System.out.println("\t\t\t   Share Moments. Stay Connected. ");
        System.out.println("\t\t\t==================================");
        System.out.println(" 1.  Register");
        System.out.println(" 2.  Login");
        System.out.println(" 3.  About");
        System.out.println(" 0.  Exit");
        System.out.println("==================================");
        System.out.print("Choose an option: ");
        
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3: 
                showAboutPage();
                break;
            case 0:
                System.out.println("Goodbye!");
                exitApp();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private void showUserMenu() {
        System.out.println("\n=== User Menu ===");
        System.out.println("1. Create Post");
        System.out.println("2. View My Posts");
        System.out.println("3. View All Posts");
        System.out.println("4. View Profile");
        System.out.println("5. Follow User");
        System.out.println("6. Unfollow User");
        System.out.println("7. View Followers");
        System.out.println("8. Add Comment");  
        System.out.println("9. View Comments"); 
        System.out.println("10. Logout");
        System.out.print("Choose an option: ");

        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                createPost();
                break;
            case 2:
                viewMyPosts();
                break;
            case 3:
                viewAllPosts();
                break;
            case 4:
                currentUser.viewProfile();
                break;
            case 5:
                followUser();
                break;
            case 6:
                unfollowUser();
                break;
            case 7:
                viewFollowers();
                break;
                case 8:
                addComment();
                break;
            case 9:
                viewComments();
                break;
            case 10:
                currentUser = null;
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    // User registration
    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        // Check if username exists
        if (users.stream().anyMatch(u -> u.getUsername().equals(username))) {
            System.out.println("Username already exists. Please choose another.");
            return;
        }
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful! Please login.");
    }
    
    // User login
    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + username + "!");
                return;
            }
        }
        
        System.out.println("Invalid username or password. Please try again.");
    }

    public static void showAboutPage() {
        System.out.println("======================================================");
        System.out.println("                   ABOUT HABESHAGRAM                  ");
        System.out.println("======================================================");
        System.out.println("Habeshagram is a Java-based mini social media console ");
        System.out.println("application developed as a practical project to explore");
        System.out.println("and demonstrate the core principles of Object-Oriented ");
        System.out.println("Programming (OOP). This project was initiated under the");
        System.out.println("guidance of our respected instructor, Mr. Melese, as a ");
        System.out.println("way to reinforce our understanding of OOP. ");
        System.out.println();
        System.out.println("The app was designed and developed by 2nd software ");
        System.out.println("engineering student at Woldia University. It allows    ");
        System.out.println("users to register, log in, create posts (text or image),");
        System.out.println("follow other users, and interact with content in a way ");
        System.out.println("that mimics real social platforms. ");
        System.out.println();
        System.out.println("Throughout its development, Habeshagram makes use of   ");
        System.out.println("all four key OOP concepts:");
        System.out.println(" - Encapsulation: Each class hides its internal state.");
        System.out.println(" - Inheritance: Posts types like TextPost and ImagePost");
        System.out.println("   extend a base Post class.");
        System.out.println(" - Abstraction: The abstract Post class provides a clean");
        System.out.println("   interface for different post types.");
        System.out.println(" - Polymorphism: Posts are handled in a general way but ");
        System.out.println("   behave differently depending on their actual type.  ");
        System.out.println();
        System.out.println("This project is a stepping stone towards mastering Java");
        System.out.println("programming and building real-world applications. Although");
        System.out.println("there are limitations in our mini app like storing the");
        System.out.println("previous data, GUI... We will try to improve in the future.");
        System.out.println();
        System.out.println();
        System.out.println("\t\t         WOLDIA UNIVERISTY");
        System.out.println("\t\t      INSTITUTE OF TECHNOLOGY");
        System.out.println("\t\t        school of computing");
        System.out.println("\t\tDepartment of Software Engineering\n");
        System.out.println("Course Title: Object Oriented Programming");
        System.out.println("Course Code: SEng2062");
        System.out.println("Project Title: [Habeshagram mimi app]A program that\n");
        System.out.print("\timplements the core OOP Concepts");
        System.out.println("Prepared by 2nd year software engineering students\n");
        
        System.out.println("Section : 1");
        System.out.println("Group : 1\n");
        
        System.out.println("\t+----+------------------------+--------------+");
        System.out.println("\t| No |        Name            |      ID      |");
        System.out.println("\t+----+------------------------+--------------+");
        System.out.println("\t| 1  | YEABTSEGA TESFAYE      |   WDU161299  |");
        System.out.println("\t| 2  | TESHOME SISAY          |   WDU161207  |");
        System.out.println("\t| 3  | ETSEGENET DAGNACHEW    |   WDU160512  |");
        System.out.println("\t| 4  | GETASIL SETEGN         |   WDU160614  |");
        System.out.println("\t| 5  | SAMRAWIT MOLLA         |   WDU161055  |");
        System.out.println("\t| 6  | TAMENECH MISSA         |   WDU161169  |");
        System.out.println("\t+----+------------------------+--------------+\n");
        
        System.out.println("\t\t\t\t\tSubmitted to: Ins. Melese"); 
        System.out.println("\t\t\t\t\tSubmission date: 08/09/2017 E.C"); 
        System.out.println("\t\t\t\t\tWoldia, Ethiopia");
        System.out.println("=======================================================================");
    }
           
    
    private void createPost() {
        System.out.println("\n=== Create Post ===");
        System.out.println("1. Text Post");
        System.out.println("2. Image Post");
        System.out.print("Choose post type: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter post content: ");
        String content = scanner.nextLine();
        
        Post post;
        if (choice == 1) {
            post = new TextPost(content, currentUser);
        } else if (choice == 2) {
            System.out.print("Enter image URL: ");
            String imageUrl = scanner.nextLine();
            post = new ImagePost(content, currentUser, imageUrl);
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        
        currentUser.addPost(post);
        System.out.println("Post created successfully!");
    }
    
    // View current user's posts
    private void viewMyPosts() {
        System.out.println("\n=== My Posts ===");
        List<Post> posts = currentUser.getPosts();
        
        if (posts.isEmpty()) {
            System.out.println("You haven't posted anything yet.");
            return;
        }
        
        for (Post post : posts) {
            post.display(); // Polymorphism in action
        }
    }
    
    // View all posts from all users
    private void viewAllPosts() {
        System.out.println("\n=== All Posts ===");
        boolean anyPosts = false;
        
        for (User user : users) {
            List<Post> posts = user.getPosts();
            if (!posts.isEmpty()) {
                anyPosts = true;
                System.out.println("\nPosts by " + user.getUsername() + ":");
                for (Post post : posts) {
                    post.display(); // Polymorphism in action
                }
            }
        }
        
        if (!anyPosts) {
            System.out.println("No posts available yet.");
        }
    }
    
    // Follow another user
    private void followUser() {
        System.out.print("Enter username to follow: ");
        String username = scanner.nextLine();
        
        if (username.equals(currentUser.getUsername())) {
            System.out.println("You can't follow yourself!");
            return;
        }
        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                currentUser.follow(user);
                System.out.println("You are now following " + username + "!");
                return;
            }
        }
        
        System.out.println("User not found.");
    }
    
    // Unfollow a user
    private void unfollowUser() {
        System.out.print("Enter username to unfollow: ");
        String username = scanner.nextLine();
        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                currentUser.unfollow(user);
                System.out.println("You have unfollowed " + username + ".");
                return;
            }
        }
        
        System.out.println("User not found or not currently following.");
    }
    
    // View current user's followers
    private void viewFollowers() {
        List<User> followers = currentUser.getFollowers();
        
        if (followers.isEmpty()) {
            System.out.println("You don't have any followers yet.");
            return;
        }
        
        System.out.println("\n=== Your Followers ===");
        for (User follower : followers) {
            System.out.println("- " + follower.getUsername());
        }
    }

    private void addComment() {
        System.out.println("\n=== Add Comment ===");
        viewAllPosts();
        
        System.out.print("Enter username of post author: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter the exact content of the post you want to comment on: ");
        String content = scanner.nextLine();
        
        // Find the post
        Post targetPost = null;
        for (User user : users) {
            for (Post post : user.getPosts()) {
                if (post.getContent().equals(content) && 
                    post.getAuthor().getUsername().equals(username)) {
                    targetPost = post;
                    break;
                }
            }
            if (targetPost != null) break;
        }
        
        if (targetPost == null) {
            System.out.println("Post not found.");
            return;
        }
        
        System.out.print("Enter your comment: ");
        String commentText = scanner.nextLine();
        targetPost.addComment(new Comment(currentUser, commentText));
        System.out.println("Comment added successfully!");
    }

    private void viewComments() {
        System.out.println("\n=== View Comments ===");
        viewAllPosts();
        
        System.out.print("Enter username of post author: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter the exact content of the post: ");
        String content = scanner.nextLine();
        
        // Find the post
        Post targetPost = null;
        for (User user : users) {
            for (Post post : user.getPosts()) {
                if (post.getContent().equals(content) && 
                    post.getAuthor().getUsername().equals(username)) {
                    targetPost = post;
                    break;
                }
            }
            if (targetPost != null) break;
        }
        
        if (targetPost == null) {
            System.out.println("Post not found.");
            return;
        }
        
        targetPost.displayComments();
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}