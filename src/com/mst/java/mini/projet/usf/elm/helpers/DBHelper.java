package com.mst.java.mini.projet.usf.elm.helpers;

import com.mst.java.mini.projet.usf.elm.core.models.DBConfig;

import javax.swing.*;
import java.io.*;
import java.sql.*;


public class DBHelper {

    //------------- attributes -------------
    private DBConfig databaseConfig;
    final private File CONFIG_FILE = AssetsProvider.dbConfigFile;
    private Connection connection;


    //    ------------- constructors -------------
    public DBHelper() {
        try {
            connectToDatabase();
        } catch (ClassNotFoundException | SQLException e) {
           DialogHelper.showErrorMessage(
                   null,"Les message suivant est survenue:\n"+ e.getMessage()
           );
        }
    }


    // -------------setters and getters -------------
    public DBConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public void setDatabaseConfig(DBConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
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
        if (!CONFIG_FILE.exists()) {
            System.out.println("Files doesn't exist ");
            return false;
        } else {
            // in case the file exists then
            // we need to check if the file contains  a valid configurations
            if (databaseConfig == null) {
                try {
                    readDatabaseConfigurations();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return connectToDatabase();

        }
    }


    //connects to database using the configs given by the user
    //returns true if the connection passed
    //else it returns false and shows an error message if there is one
    public boolean connectToDatabase() throws ClassNotFoundException, SQLException {

        //if no configurations found
        if (databaseConfig == null) return false;

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + databaseConfig.getServerAdr() + "/" + databaseConfig.getDatabaseName(),
                databaseConfig.getUsername(), databaseConfig.getPassword());
        // the connection passed
        return connection != null;
    }


    //closes the database connection and shows an error if it failed
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();

        }
    }


    //This method saves the database configurations to [CONFIG_FILE -> /assets/db.config]
    public boolean saveDatabaseConfigurations() throws Exception {
        if (databaseConfig == null || databaseConfig.hasEssentialConfigurations()) return false;
        boolean saved = false;
        if (CONFIG_FILE.getParentFile().canWrite()) {
            try {
                FileWriter fileWriter = new FileWriter(CONFIG_FILE, false);
                fileWriter.write(databaseConfig.toString());
                fileWriter.close();
                //this the only the value of isSuccessful will change ...
                saved = true;
            } catch (IOException e) {
                throw (new Exception("Erreur survenue lors de l'ecriture au fichier" + e.getMessage()));
            }
        } else {
            throw (new Exception("La permission d'écriture au dossier actuel n'est pas accordée!"));
        }
        return saved;
    }


    // reads the configurations from db.config and assigns them to  [databaseConfig] instance
    //this method is throwing exceptions so the program can catch them and show an error dialogs
    private void readDatabaseConfigurations() throws Exception {
        if (CONFIG_FILE.getParentFile().canRead()) {
            try {
                //clearing the table
                BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_FILE));
                String line;
                String[] configs = new String[5];
                //reading line by line
                int configIndex = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] cfg;
                    cfg = line.split("=");
                    configs[configIndex] = cfg.length != 2 ? "" : cfg[1];
                    configIndex++;
                }
                databaseConfig = new DBConfig(configs);
            } catch (IOException e) {
                throw (new Exception("Erreur survenue lors de la lecture du fichier: \n" + e.getMessage()));
            }
        } else {
            throw (new Exception("La permission de la lecture du fichier de la configuration n'est pas accordée!"));
        }
    }


}
