package com.example.gebeya_mood.pojos;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("error")
    private boolean err;

    @SerializedName("message")
    private String msg;


    public ApiResponse(boolean err, String msg) {
        this.err = err;
        this.msg = msg;
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
