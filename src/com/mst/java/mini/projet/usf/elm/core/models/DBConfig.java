package com.mst.java.mini.projet.usf.elm.core.models;

import java.util.Objects;

/*
 * This model is the container of database configuration
 */
public class DBConfig {


    //  ---------- constructors  ----------
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

    //  ---------- attributes  ---------
    private String serverAdr;
    private String databaseName;
    private String tableName;
    private String username;
    private String password;

    //  ---------- getters ans setters  ----------


    public void setServerAdr(String _serverAdr) {
        this.serverAdr = cleanUpServerName(_serverAdr);
        System.out.println(getServerAdr());

    }

    //Cleaning up the serverAdr attribute so the user won't worry about
    // the form of the server name
    private String cleanUpServerName(String _serverAdr) {

        if (_serverAdr == null) return  "";
        String temp=null;
        if (_serverAdr.startsWith("http://")) {
            temp= _serverAdr.replaceAll("http://", "").trim();
        } else if (_serverAdr.startsWith("https://")) {
            temp= _serverAdr.replaceAll("https://", "").trim();
        } else {
            temp= _serverAdr;
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

}
