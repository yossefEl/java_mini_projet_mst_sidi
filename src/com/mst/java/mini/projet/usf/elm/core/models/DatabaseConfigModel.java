package com.mst.java.mini.projet.usf.elm.core.models;
/*
 * This model is the container of database configuration
 */
public class DatabaseConfigModel {


    public DatabaseConfigModel(String serverAdr, String databaseName, String tableName, String username, String password) {
    this.serverAdr = serverAdr;
    this.databaseName = databaseName;
    this.tableName = tableName;
    this.username = username;
    this.password = password;
}
    private String serverAdr;
    private String databaseName;
    private String tableName;
    private String username;
    private String password;




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

    @Override
    public String toString() {
        return
                "serverAdr='" + serverAdr + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'';
    }



}
