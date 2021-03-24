package com.mst.java.mini.projet.usf.elm.core.models;

import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client extends User{

    //---------- attributes ---------
    DBHelper dbHelper;
    private String id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String address;


    //---------- constructors ---------
    public Client()  {
        new DBHelper();
    }
     public Client(String id, String firstName, String lastName, String birthday, String adress) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            this.address = adress;
       dbHelper=  new DBHelper();
        }
    //---------- methods ---------

    @Override
    public void create() throws SQLException, ClassNotFoundException {
        Connection connection= dbHelper.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(
                "INSERT INTO clients(id, nom, prenom, date_naiss, adresse) " +
                        "VALUES ('"+id+"','"+firstName+"','"+lastName+"','"+birthday+"','"+ address +"')");
        dbHelper.closeConnection();
    }

    @Override
    public User get() throws SQLException {
        Connection connection= dbHelper.getConnection();
        Statement statement=connection.createStatement();
        ResultSet results= statement.executeQuery(
                "SELECT FROM clients where id="+id);
        dbHelper.closeConnection();
        while(results.next()){
            System.out.println(results.getString("id"));
        }
        return this;
    }

    /**
     * This methods deletes the user from the database
     * @throws SQLException  this is throwing when an exception occurred during the interaction with
     *      * mysql database
     */
    @Override
    public void delete() throws SQLException {
        Connection connection= dbHelper.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(
                "INSERT INTO clients(id, nom, prenom, date_naiss, adresse) " +
                        "VALUES ('"+id+"','"+firstName+"','"+lastName+"','"+birthday+"','"+ address +"')");
        dbHelper.closeConnection();
    }

    /**
     *
     * This method updates the client information in the database based on the new ones
     * inserted by the admin
     * @throws SQLException this is throwing when an exception occurred during the interaction with
     * mysql database
     */
    @Override
    public void update() throws SQLException {

        Connection connection= dbHelper.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate("UPDATE clients SET   nom='"+firstName+"', prenom='"+lastName+"', date_naiss='"+birthday+"', adresse='"+ address +"' where id='"+id+"'");
        dbHelper.closeConnection();
    }


    //---------- getters and setters ---------

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }


    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
