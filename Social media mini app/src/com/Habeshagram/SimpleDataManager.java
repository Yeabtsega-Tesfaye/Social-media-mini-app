package com.Habeshagram;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleDataManager {
    private static final String DATA_FILE = "habeshagram_data.txt";

    public static void saveData(List<User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (User user : users) {
                // Save user basics
                writer.println("USER:" + user.getUsername() + ":" + user.getPassword());
                
                // Save user's posts
                for (Post post : user.getPosts()) {
                    if (post instanceof TextPost) {
                        writer.println("TEXT_POST:" + user.getUsername() + ":" + post.getContent());
                    } else if (post instanceof ImagePost) {
                        writer.println("IMAGE_POST:" + user.getUsername() + ":" + 
                                      post.getContent() + ":" + ((ImagePost)post).getImageUrl());
                    }
                }
                
                // Save followers
                for (User follower : user.getFollowers()) {
                    writer.println("FOLLOW:" + user.getUsername() + ":" + follower.getUsername());
                }
            }
            System.out.println("Data saved to " + new File(DATA_FILE).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static List<User> loadData() {
        List<User> users = new ArrayList<>();
        File file = new File(DATA_FILE);
        
        if (!file.exists()) return users;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                switch (parts[0]) {
                    case "USER":
                        users.add(new User(parts[1], parts[2]));
                        break;
                    case "TEXT_POST":
                        findUser(users, parts[1]).addPost(new TextPost(parts[2], findUser(users, parts[1])));
                        break;
                    case "IMAGE_POST":
                        findUser(users, parts[1]).addPost(new ImagePost(parts[2], findUser(users, parts[1]), parts[3]));
                        break;
                    case "FOLLOW":
                        findUser(users, parts[1]).follow(findUser(users, parts[2]));
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
        return users;
    }

    private static User findUser(List<User> users, String username) {
        return users.stream()
                   .filter(u -> u.getUsername().equals(username))
                   .findFirst()
                   .orElse(null);
    }
}