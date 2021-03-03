package com.mst.java.mini.projet.usf.elm.core.controllers;
import com.mst.java.mini.projet.usf.elm.core.models.DatabaseConfigModel;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;
import java.io.File;


public class ConfigureDatabaseController {
//------------- attributes -------------
    private DatabaseConfigModel databaseConfig;


//    ------------- constructors -------------
    public ConfigureDatabaseController(){
        if(isDatabaseConfigured()){
            readDatabaseConfigurations();
        }
    }




    // -------------setters and getters -------------
    public DatabaseConfigModel getDatabaseConfig() {
        return databaseConfig;
    }

    public void setDatabaseConfig(DatabaseConfigModel databaseConfig) {
        this.databaseConfig = databaseConfig;
    }



    //-------------methods -------------

    public boolean isDatabaseConfigured() {
        return false;
    }

    public void saveDatabaseConfigurations(DatabaseConfigModel config){
        databaseConfig =config;
    }

    private void readDatabaseConfigurations() {
    }



}
