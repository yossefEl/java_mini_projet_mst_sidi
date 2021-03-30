package com.mst.java.mini.projet.usf.elm.helpers;

import com.mst.java.mini.projet.usf.elm.core.models.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * This class manages the database connections as well as its configurations
 */
public class DBHelper {

    //------------- attributes -------------
    private static DBConfig databaseConfig;
    private Connection connection;


    //    ------------- constructors -------------
    public DBHelper() {
        databaseConfig = new DBConfig();
        try {
            databaseConfig.readConfiguration();
        } catch (Exception e) {
            //System.out.println("Impossible de lire la configuration!");
        }
    }


    // -------------setters and getters -------------
    public DBConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public void setDatabaseConfig(DBConfig databaseConfig) {
        DBHelper.databaseConfig = databaseConfig;
    }

    public Connection getConnection() {
        return connection;
    }


    //-------------methods -------------
    /*this method checks if the database is already configured or not
    if yes then it returns true
    otherwise returns false
    */
    public boolean isDatabaseConfigured() throws SQLException, ClassNotFoundException {
        //checking the existence of the configuration file
        if (!AssetsProvider.dbConfigFile.exists()) {
            //System.out.println("Files doesn't exist ");
            return false;
        } else {
            // in case the file exists then
            // we need to check if the file contains  a valid configurations
            try {
                databaseConfig.readConfiguration();
            } catch (Exception e) {
                //System.out.println(e.getMessage());
                e.printStackTrace();
                return false;
            }
            return connectToDatabase();
        }
    }

    //connects to database using the configs given by the user
    //returns true if the connection passed
    //else it returns false and shows an error message if there is one
    public boolean connectToDatabase() {

        //if no configurations found

        if (databaseConfig == null) return false;
//        if(!databaseConfig.hasEssentialConfigurations()) {
//            try {
//                databaseConfig.readConfiguration();
//            } catch (Exception e) {
//                DialogHelper.showErrorMessage(null, "Une erreur s'est produite lors de la tentative de connexion à la base de données :\n" + e.getMessage());
//            }
//        }

        //else
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + databaseConfig.getServerAdr() + "/" + databaseConfig.getDatabaseName(),
                    databaseConfig.getUsername(), databaseConfig.getPassword());

            if (connection != null) {
                // the connection passed
                return true;
            }
        } catch (Exception e) {
            //System.out.println("error: " + e.getMessage());
            DialogHelper.showErrorMessage(null, "Une erreur s'est produite lors de la tentative de connexion à la base de données :\n" + e.getMessage());
        }

        return false;
    }


    //closes the database connection and shows an error if it failed
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();

        }
    }


}
