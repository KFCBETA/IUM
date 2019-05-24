package com.agroup.ium.Structure;

public class PostStructure {

    private String userName;
    private String postDate;
    private String postContent;
    private String imageLink;


    //TODO: Create Real Post Structure
    public PostStructure() {

    }

    public PostStructure(String userName, String postDate, String postContent, String imageLink) {
        this.userName = userName;
        this.postDate = postDate;
        this.postContent = postContent;
        this.imageLink = imageLink;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getImageLink() {
        return imageLink;
    }
}
