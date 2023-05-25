package com.example.eproject_1;

public class Users {
    String userid,name,profile;

    public Users() {
    }

    public Users(String userid, String name, String profile) {
        this.userid = userid;
        this.name = name;
        this.profile = profile;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
