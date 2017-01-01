package com.wings.persistence;


public class Users extends UsersKey {

    
    private String name;

    
    private String password;

    
    private String authorityId;

    
    private String districtId;

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        if (name != null) {
            name = name.trim();
        }
        this.name = name;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        if (password != null) {
            password = password.trim();
        }
        this.password = password;
    }

    
    public String getAuthorityId() {
        return authorityId;
    }

    
    public void setAuthorityId(String authorityId) {
        if (authorityId != null) {
            authorityId = authorityId.trim();
        }
        this.authorityId = authorityId;
    }

    
    public String getDistrictId() {
        return districtId;
    }

    
    public void setDistrictId(String districtId) {
        if (districtId != null) {
            districtId = districtId.trim();
        }
        this.districtId = districtId;
    }
}
