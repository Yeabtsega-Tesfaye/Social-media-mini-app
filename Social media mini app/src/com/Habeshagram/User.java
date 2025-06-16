package com.Habeshagram;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<User> followers;
    private List<Post> posts;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }
    
    // Getters and setters (encapsulation)
    public String getUsername() {
        return username;
    }
    
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public List<User> getFollowers() {
        return new ArrayList<>(followers); // Return copy for encapsulation
    }
    
    public List<Post> getPosts() {
        return new ArrayList<>(posts); // Return copy for encapsulation
    }
    
    // Methods for user actions
    public void follow(User user) {
        if (!user.followers.contains(this)) {
            user.followers.add(this);
        }
    }
    
    public void unfollow(User user) {
        user.followers.remove(this);
    }
    
    public void addPost(Post post) {
        posts.add(post);
    }
    
    public void viewProfile() {
        System.out.println("\n=== " + username + "'s Profile ===");
        System.out.println("Followers: " + followers.size());
        System.out.println("Posts: " + posts.size());
    }

    public String getPassword() {
        return password;
    }
}
