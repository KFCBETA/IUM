package com.agroup.ium;

public class UserStructure {

    private String userName;
    private String userImage;

    public UserStructure(String userName, String userImage) {
        this.userName = userName;
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserImage() {
        return userImage;
    }
}
