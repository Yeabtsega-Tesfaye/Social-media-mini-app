package com.Habeshagram;

public class ImagePost extends Post {
    private String imageUrl;
    
    public ImagePost(String content, User author, String imageUrl) {
        super(content, author);
        this.imageUrl = imageUrl;
    }
    
    @Override
    public void display() {
        System.out.println("\n[Image Post by " + getAuthor().getUsername() + "]");
        System.out.println(getContent());
        System.out.println("Image URL: " + imageUrl);
        System.out.println("Posted at: " + getTimestamp());
        System.out.println("Comments: " + getComments().size());
    }

    public String getImageUrl() {
        return imageUrl;
    }
}