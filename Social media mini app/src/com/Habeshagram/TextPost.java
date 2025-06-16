package com.Habeshagram;

public class TextPost extends Post {
    public TextPost(String content, User author) {
        super(content, author);
    }
    
    @Override
    public void display() {
        System.out.println("\n[Text Post by " + getAuthor().getUsername() + "]");
        System.out.println(getContent());
        System.out.println("Posted at: " + getTimestamp());
        System.out.println("Comments: " + getComments().size());
    }
}
