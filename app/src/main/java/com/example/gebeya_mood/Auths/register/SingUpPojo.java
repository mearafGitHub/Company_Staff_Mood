package com.example.gebeya_mood.Auths.register;
import java.io.Serializable;

import com.example.gebeya_mood.users.UserResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingUpPojo implements Serializable
{
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_modified")
    @Expose
    private String dateModified;
    @SerializedName("__v")
    @Expose
    private Integer v;
    private final static long serialVersionUID = -2027896734286553529L;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SingUpPojo withRole(String role) {
        this.role = role;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SingUpPojo withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingUpPojo withName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SingUpPojo withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SingUpPojo withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public SingUpPojo withSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public SingUpPojo withTeam(String team) {
        this.team = team;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public SingUpPojo withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public SingUpPojo withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public SingUpPojo withV(Integer v) {
        this.v = v;
        return this;
    }
}