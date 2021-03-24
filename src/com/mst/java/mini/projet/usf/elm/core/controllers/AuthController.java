package com.mst.java.mini.projet.usf.elm.core.controllers;


import com.mst.java.mini.projet.usf.elm.core.models.Admin;
import com.mst.java.mini.projet.usf.elm.core.views.HomeView;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.EncryptionHelper;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthController {

    //-------constructors ---------
    public AuthController() {
        setLoggedIn(false);
    }

    public AuthController(DBHelper databaseController) {
        this.databaseController = databaseController;
    }

    //------- attributes ---------
    private boolean isLoggedIn;
    private Admin admin;
    private DBHelper databaseController;
    private final File SESSION_FILE = AssetsProvider.userSessionFile;

    //-------getters and setters ---------
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    //-------methods ---------
    public boolean isAuthenticated() {

        return false;
    }

    /**
     * @return true if the authentication succeeded else it will return false
     * @throws SQLException : this exception will produced if there is any sql errors
     *                      so we can show the Error message dialog
     */
    public boolean authenticate() throws Exception {
        if (admin == null || !admin.hasUsernameAndPassword()) {
            readSession();
        }
        setAdmin(admin);
        databaseController.connectToDatabase();
        PreparedStatement statement;
        ResultSet resultSet;
        //create a select query to check if the username and the password exist in the database
        String query = "SELECT * FROM users_db.users WHERE username = ? AND password = ?";

        try {
            statement = databaseController.getConnection().prepareStatement(query);
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());

            resultSet = statement.executeQuery();
//            TODO  execute the query and test

            //if(password.contains("123") && username.contains("test")) {
            if (resultSet.next()) {
                setLoggedIn(true);
                return true;
            }
        } catch (Exception exception) {
            throw new Exception("Erreur innatendue: \n" + exception.getMessage());
        }
        return true;
    }


    public boolean saveSession(Admin admin) throws Exception {
        if (admin == null || admin.hasUsernameAndPassword()) return false;
        boolean saved = false;
        if (SESSION_FILE.getParentFile().canWrite()) {
            try {
                FileWriter fileWriter = new FileWriter(SESSION_FILE, false);
                fileWriter.write(EncryptionHelper.encrypt(admin.toString()));
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

    private void readSession() throws Exception {
        if (!SESSION_FILE.exists()) {
            throw new Exception("Le fichier de votre session est introuvale");
        }

        if (SESSION_FILE.getParentFile().canRead()) {
            try {
                //clearing the table
                BufferedReader bufferedReader = new BufferedReader(new FileReader(SESSION_FILE));


                String line;
                //reading line by line
                while ((line = bufferedReader.readLine()) != null) {
                    //line contains the current user session
                    admin = new Admin(EncryptionHelper.decrypt(line).split(":"));
                }
            } catch (IOException e) {
                throw (new Exception("Erreur survenue lors de la lecture du fichier: \n" + e.getMessage()));
            }
        } else {
            throw (new Exception("La permission de la lecture du fichier de la configuration n'est pas accordée!"));
        }
    }




}
