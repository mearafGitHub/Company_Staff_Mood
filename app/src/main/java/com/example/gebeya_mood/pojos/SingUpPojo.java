package com.example.gebeya_mood.pojos;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingUpPojo implements Serializable
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
    private final static long serialVersionUID = 2046294547053259569L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SingUpPojo withMessage(String message) {
        this.message = message;
        return this;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public SingUpPojo withUser(UserResponse user) {
        this.user = user;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SingUpPojo withToken(String token) {
        this.token = token;
        return this;
    }

}