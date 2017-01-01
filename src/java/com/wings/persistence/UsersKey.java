package com.wings.persistence;


public class UsersKey {

    
    private String userId;

    
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        if (userId != null) {
            userId = userId.trim();
        }
        this.userId = userId;
    }
}
