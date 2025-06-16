package com.Habeshagram;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Post {
    private String content;
    private User author;
    private Date timestamp;
    private List<Comment> comments;
    
    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.timestamp = new Date(); // Current time
        this.comments = new ArrayList<>();
    }
    
    public String getContent() {
        return content;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments); // Return copy for encapsulation
    }
    
    public void display() {
        System.out.println("\n[" + getClass().getSimpleName() + " by " + getAuthor().getUsername() + "]");
        System.out.println(getContent());
        System.out.println("Posted at: " + getTimestamp());
        System.out.println("Comments (" + getComments().size() + "):");
        
        // Show up to 2 most recent comments
        int commentsToShow = Math.min(2, getComments().size());
        for (int i = 0; i < commentsToShow; i++) {
            Comment comment = getComments().get(i);
            System.out.print("  ");
            comment.display();
        }
        
        if (getComments().size() > 2) {
            System.out.println("  ... and " + (getComments().size() - 2) + " more");
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
    
    public void displayComments() {
        if (comments.isEmpty()) {
            System.out.println("No comments yet.");
            return;
        }
        
        System.out.println("\nComments:");
        for (Comment comment : comments) {
            comment.display();
        }
    }

    
}