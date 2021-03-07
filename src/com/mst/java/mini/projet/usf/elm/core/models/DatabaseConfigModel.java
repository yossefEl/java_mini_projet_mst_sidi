package com.mst.java.mini.projet.usf.elm.core.models;

import java.util.Objects;

/*
 * This model is the container of database configuration
 */
public class DatabaseConfigModel {

    //  ---------- constructors  ----------
    public DatabaseConfigModel(String serverAdr, String databaseName, String tableName, String username, String password) {
        this.serverAdr = serverAdr;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.username = username;
        this.password = password;
    }

    public DatabaseConfigModel(String[] configs){
        fromArray(configs);
    }
    //  ---------- attributes  ----------
    private String serverAdr;
    private String databaseName;
    private String tableName;
    private String username;
    private String password;

    //  ---------- getters ans setters  ----------

    public String getServerAdr() {
        return serverAdr;
    }

    public void setServerAdr(String serverAdr) {
        this.serverAdr = serverAdr;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void fromArray(String[] configs){
        this.serverAdr=configs[0];
        this.databaseName=configs[1];
        this.tableName=configs[2];
        this.username=configs[3];
        this.password=configs[4];
    }

    public boolean hasEssentialConfigurations(){
        return !isBlankOrNull(serverAdr) || !isBlankOrNull(username) || !isBlankOrNull(databaseName);
    }

    private boolean isBlankOrNull(String attribute){
      return (attribute != null && !Objects.equals(attribute, "") && !Objects.equals(attribute, " "));
    }

}
