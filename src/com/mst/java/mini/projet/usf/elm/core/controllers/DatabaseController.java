package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.models.DatabaseConfigModel;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import javax.swing.*;
import java.io.*;
import java.sql.*;


public class DatabaseController {

    //------------- attributes -------------


    private DatabaseConfigModel databaseConfig;
    final private File CONFIG_FILE = AssetsProvider.dbConfigFile;
    JComponent currentView;
    private Statement statement;
    private Connection connection;


    //    ------------- constructors -------------

    public DatabaseController(JComponent currentView) {
        this.currentView = currentView;
    }


    // -------------setters and getters -------------
    public DatabaseConfigModel getDatabaseConfig() {
        return databaseConfig;
    }

    public void setDatabaseConfig(DatabaseConfigModel databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }


    //-------------methods -------------


    /*this method checks if the database is already configured or not
    if yes then it returns true
    otherwise returns false
    */
    public boolean isDatabaseConfigured() {
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
    public boolean connectToDatabase() {

        //if no configurations found
        if (databaseConfig == null) return false;

        //else
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + databaseConfig.getServerAdr() + "/" + databaseConfig.getDatabaseName(),
                    databaseConfig.getUsername(), databaseConfig.getPassword());

            if (connection != null) {
                // the connection passed
                return true;
            }
//            ResultSet rs = getStatement().executeQuery("SELECT * FROM clients");
//            while (rs.next())
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            DialogHelper.showErrorMessage(currentView, "Une erreur s'est produite lors de la tentative de connexion à la base de données :\n" + e.getMessage());
        }

        //the program will never reach here if the connection passed
        // which means that there is an error occurred
        return false;
    }


    //closes the database connection and shows an error if it failed
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            DialogHelper.showErrorMessage(currentView, "Impossible de fermer la connexion à la base de données! :\n"
                    + exception.getMessage());
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
                    configs[configIndex] = cfg.length!=2?"":cfg[1];
                    configIndex++;
                }
                databaseConfig = new DatabaseConfigModel(configs);
            } catch (IOException e) {
                throw (new Exception("Erreur survenue lors de la lecture du fichier: \n" + e.getMessage()));
            }
        } else {
            throw (new Exception("La permission de la lecture du fichier de la configuration n'est pas accordée!"));
        }
    }


}
