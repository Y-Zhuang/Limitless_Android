package com.zhuang.limitless_android.model.entity;

import java.util.Arrays;

public class User {

    public User() {
    }

    public User(String userName, String userPassword, byte[] userPicture) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPicture = userPicture;
    }

    private Integer id;
    private String userName;
    private String userPassword;
    private byte[] userPicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public byte[] getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(byte[] userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPicture=" + Arrays.toString(userPicture) +
                '}';
    }
}
