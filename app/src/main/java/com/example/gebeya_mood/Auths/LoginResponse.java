package com.example.gebeya_mood.Auths;

import com.example.gebeya_mood.Auths.users.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("error")
    private boolean err;
    private User user;
    @SerializedName("message")
    private String msg;


    public LoginResponse(boolean err, String msg, User user) {
        this.err = err;
        this.msg = msg;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isErr() {
        return err;
    }

    public void setErr(boolean err) {
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
