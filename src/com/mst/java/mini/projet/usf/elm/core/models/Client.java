package com.mst.java.mini.projet.usf.elm.core.models;

import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Client implements User {

    //---------- attributes ---------
    private final DBHelper dbHelper;
    private int id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String address;


    //---------- constructors ---------
    public Client() {
        dbHelper = new DBHelper();
    }

    public Client(
            int id, String firstName, String lastName, String birthday, String adress) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = adress;
        dbHelper = new DBHelper();
    }
    //---------- methods ---------

    /**
     * this method is for getting all the clients stored in the database -> clients table
     * this method is related to the client Class but not to a specific client this why it's declared static
     *
     * @return List of Clients
     */
    public static ArrayList<Client> all() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        ArrayList<Client> clients = new ArrayList<>();
        dbHelper.connectToDatabase();
        Connection connection = dbHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(
                "SELECT * FROM " + dbHelper.getDatabaseConfig().getTableName());

        while (results.next()) {
            Client client = new Client();
            client.setId(results.getInt(1));
            client.setFirstName(results.getString(2));
            client.setLastName(results.getString(3));
            client.setBirthday(results.getString(4));
            client.setAddress(results.getString(5));
            clients.add(client);
        }
        dbHelper.closeConnection();
        return clients;
    }

    /**
     * inserts the client's data into database
     *
     * @throws SQLException           if an error occurred during inserting data into database
     * @throws ClassNotFoundException if the JDBC Class is not found or the path to it is broken
     */
    @Override
    public void create() throws SQLException, ClassNotFoundException {
        dbHelper.connectToDatabase();
        Connection connection = dbHelper.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "INSERT INTO " + dbHelper.getDatabaseConfig().getTableName() + "(id, nom, prenom, date_naiss, adresse) " +
                        "VALUES ('" + id + "','" + firstName + "','" + lastName + "','" + birthday + "','" + address + "')");
        dbHelper.closeConnection();

    }

    /**
     * It gets the Client from the database by its identifier
     * and setts the new values to its attributes
     *
     * @throws SQLException in case of SQL syntax error if the datbase not connected...etc
     */
    @Override
    public void get() throws SQLException {
        dbHelper.connectToDatabase();
        Connection connection = dbHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(
                "SELECT * FROM " + dbHelper.getDatabaseConfig().getTableName() + " where id=" + id);

        while (results.next()) {
            setId(results.getInt(1));
            setFirstName(results.getString(2));
            setLastName(results.getString(3));
            setBirthday(results.getString(4));
            setAddress(results.getString(5));
        }
        dbHelper.closeConnection();
    }

    /**
     * This methods deletes the user from the database
     *
     * @throws SQLException this is throwing when an exception occurred during the interaction with
     *                      * mysql database
     */
    @Override
    public void delete() throws SQLException {
        dbHelper.connectToDatabase();
        Connection connection = dbHelper.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM "+ dbHelper.getDatabaseConfig().getTableName() +" where id=" + id);
        dbHelper.closeConnection();
    }

    /**
     * This method updates the client information in the database based on the new ones
     * inserted by the admin
     *
     * @throws SQLException this is throwing when an exception occurred during the interaction with
     *                      mysql database
     */
    @Override
    public void update() throws SQLException {
        dbHelper.connectToDatabase();
        Connection connection = dbHelper.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE "+ dbHelper.getDatabaseConfig().getTableName() +" SET   nom='" + firstName + "', prenom='" + lastName + "', date_naiss='" + birthday + "', adresse='" + address + "' where id='" + id + "'");
        dbHelper.closeConnection();
    }

    /**
     * @return true if the values of this client instance are valid [isBlackOrNull for each is false]
     * else it returns false
     */


    public boolean validate() {
        return !isBlankOrNull(id == 0 ? "" : String.valueOf(id)) &&
                !isBlankOrNull(firstName) &&
                !isBlankOrNull(lastName) &&
                !isBlankOrNull(birthday) &&
                !isBlankOrNull(address);
    }

    /**
     * @param attribute :a variable to process
     * @return true in the following cases:
     * - empty [ = '']
     * - blank [= "    "]
     * - null
     * otherwise it returns true
     */
    public static boolean isBlankOrNull(String attribute) {
        return (attribute == null ||
                Objects.equals(attribute, "") ||
                Objects.equals(attribute, " ") ||
                attribute.isEmpty());
    }


    /**
     * Checks the existence of the client in the database using its identifier
     *
     * @return true if current Client exist in the database
     * otherwise it returns false
     */
    public boolean existInDatabase() {

        try {
            dbHelper.connectToDatabase();
            Connection connection = dbHelper.getConnection();

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM " + dbHelper.getDatabaseConfig().getTableName() + " where id=" + id);
            boolean exist = false;
            while (results.next()) {
                exist = true;
            }
            return exist;


        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }


    }


    @Override
    public String toString() {
        return
                ", id='" + id + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", birthday='" + birthday + '\'' +
                        ", address='" + address + '\''
                ;
    }
    //---------- getters and setters ---------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
