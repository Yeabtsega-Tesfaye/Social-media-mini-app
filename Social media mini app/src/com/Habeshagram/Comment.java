package com.Habeshagram;

import java.util.Date;

public class Comment {
    private User author;
    private String text;
    private Date timestamp;
    
    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
        this.timestamp = new Date();
    }
    
    public void display() {
        System.out.println(author.getUsername() + ": " + text);
        System.out.println("  (" + timestamp + ")");
    }
    
    // Getters
    public User getAuthor() {
        return author;
    }
    
    public String getText() {
        return text;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
}