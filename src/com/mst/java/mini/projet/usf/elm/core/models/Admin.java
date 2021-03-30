package com.mst.java.mini.projet.usf.elm.core.models;

import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin implements User {


    DBHelper dbHelper;
    //-------- attributes -------
    private boolean isLogged;
    private String id;
    private String fullName;
    private String username;
    private String password;

    //-------- controllers -------
    public Admin() {
        isLogged = false;
        dbHelper = new DBHelper();
    }

    public Admin(String id, String fullName, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        isLogged = false;
        dbHelper = new DBHelper();
    }


    //-------- setters and getters -------


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    //-------- methods -------


    @Override
    public void create() {
        //    inserts  an admin into the database
    }

    @Override
    public void get() {
//        gets the user from the database

    }

    @Override
    public void delete() {
//        delete the user from database

    }

    @Override
    public void update() {

//        update the admin information in the database

    }


    /**
     * @return true if the authentication succeeded else it will return false
     * @throws SQLException : this exception will produced if there is any sql errors
     *                      so we can show the Error message dialog
     */
    public boolean authenticate() throws Exception {

        ResultSet resultSet;
        //create a select query to check if the username and the password exist in the database
        String query = "SELECT * FROM admins WHERE login = '" + username + "' AND password ='" + password + "'";

        dbHelper.connectToDatabase();
        Connection connection = dbHelper.getConnection();
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {

            setLogged(true);
            return true;
        }
        return false;
    }
}
