package com.example.gebeya_mood.Auths.login;

import java.io.Serializable;

import com.example.gebeya_mood.Auths.users.UserResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPojo implements Serializable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private UserResponse user;
    @SerializedName("token")
    @Expose
    private String token;
    private final static long serialVersionUID = 4481245532205943356L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginPojo withMessage(String message) {
        this.message = message;
        return this;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public LoginPojo withUser(UserResponse user) {
        this.user = user;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginPojo withToken(String token) {
        this.token = token;
        return this;
    }

}