package com.mst.java.mini.projet.usf.elm.core.models;

import java.util.Objects;

public class AdminModel {


    //-------- controllers -------
    public AdminModel(String[] data) {
        fromArray(data);
    }

    public AdminModel(String id, String fullName, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    //-------- attributes -------
    private String id;
    private String fullName;
    private String username;
    private String password;


    //-------- setters and gettters -------

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    //-------- methods -------


    @Override
    public String toString() {
        return getId() +":"+getFullName()+":"+getUsername()+":"+getPassword();
    }

    private void fromArray(String[] data) {
        setId(data[0]);
        setFullName(data[1]);
        setUsername(data[2]);
        setPassword(data[3]);

    }

    public boolean hasUsernameAndPassword() {
        return !isBlankOrNull(username) && !isBlankOrNull(password);
    }

    private boolean isBlankOrNull(String attribute) {
        return (attribute == null || Objects.equals(attribute, "") || Objects.equals(attribute, " "));
    }



}
