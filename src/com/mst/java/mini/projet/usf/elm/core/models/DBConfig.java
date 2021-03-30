package com.mst.java.mini.projet.usf.elm.core.models;

import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import java.io.*;
import java.util.Objects;

/*
 * This model is the container of database configuration
 */
public class DBConfig {


    //  ---------- constructors  ----------

    public DBConfig(){

    }
    public DBConfig(String serverAdr, String databaseName, String tableName, String username, String password) {
        setServerAdr(serverAdr);
        setDatabaseName(databaseName);
        setTableName(tableName);
        setUsername(username);
        setPassword(password);
    }

    public DBConfig(String[] configs) {
        fromArray(configs);
    }

    //  ---------- attributes  ---------;
    private String serverAdr;
    private String databaseName;
    private String tableName;
    private String username;
    private String password;

    //  ---------- getters ans setters  ----------


    public void setServerAdr(String _serverAdr) {
        this.serverAdr = cleanUpServerName(_serverAdr);


    }

    //Cleaning up the serverAdr attribute so the user won't worry about  the form of the server name
    //The user may insert the server name like http://localhost:port/ and
    //this is a mal formed syntax for the JDBC connector
    private String cleanUpServerName(String _serverAdr) {

        if (_serverAdr == null) return "";
        String temp = null;
        if (_serverAdr.startsWith("http://")) {
            temp = _serverAdr.replaceAll("http://", "").trim();
        } else if (_serverAdr.startsWith("https://")) {
            temp = _serverAdr.replaceAll("https://", "").trim();
        } else {
            temp = _serverAdr;
        }

        if (temp.endsWith("/")) {
            temp = temp.replace("/", "");
        }

        return temp;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName != null ? databaseName.trim() : null;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName != null ? tableName.trim() : null;
    }

    public void setUsername(String username) {
        this.username = username != null ? username.trim() : null;
    }

    public void setPassword(String password) {
        this.password = password != null ? password.trim() : null;
    }

    public String getServerAdr() {
        return serverAdr;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    //  ---------- methods  ----------
    @Override
    public String toString() {
        return
                "serverAdr=" + serverAdr + '\n' +
                        "databaseName=" + databaseName + '\n' +
                        "tableName=" + tableName + '\n' +
                        "username=" + username + '\n' +
                        "password=" + password;
    }

    public void fromArray(String[] configs) {
        setServerAdr(configs[0]);
        setDatabaseName(configs[1]);
        setTableName(configs[2]);
        setUsername(configs[3]);
        setPassword(configs[4]);
    }

    public boolean hasEssentialConfigurations() {
        return !isBlankOrNull(serverAdr) && isBlankOrNull(username) && !isBlankOrNull(databaseName);
    }

    private boolean isBlankOrNull(String attribute) {
        return (attribute == null || Objects.equals(attribute, "") || Objects.equals(attribute, " "));
    }


    //This method saves the database configurations to [CONFIG_FILE -> /assets/db.config]
    public boolean saveConfiguration() throws Exception {
        if (hasEssentialConfigurations()) return false;
        boolean saved = false;
        if (AssetsProvider.dbConfigFile.getParentFile().canWrite()) {
            try {
                FileWriter fileWriter = new FileWriter(AssetsProvider.dbConfigFile, false);
                fileWriter.write(toString());
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
    public void readConfiguration() throws Exception {
        if (AssetsProvider.dbConfigFile.getParentFile().canRead()) {
            try {
                //clearing the table
                BufferedReader bufferedReader = new BufferedReader(new FileReader(AssetsProvider.dbConfigFile));
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
                //initializes the variables/attributes s
                fromArray(configs);
                bufferedReader.close();
            } catch (IOException e) {
                throw (new Exception("Erreur survenue lors de la lecture du fichier: \n" + e.getMessage()));
            }
        } else {
            throw (new Exception("La permission de la lecture du fichier de la configuration n'est pas accordée!"));
        }
    }


}
