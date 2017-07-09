package com.example.bublly.android_app_attendence_alerts;

/**
 * Created by BUBLLY on 07-04-2016.
 */
public class DataProvider {

    private String username;
    private String userid;
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DataProvider(String username,String userid,String password)
    {
        this.username = username;
        this.userid = userid;
        this.password = password;

    }
}
