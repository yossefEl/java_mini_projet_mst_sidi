package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.models.DatabaseConfigModel;
import com.mst.java.mini.projet.usf.elm.helpers.PathHelper;
import java.io.File;


public class ConfigureDatabaseController {
    final private String DB_CONFIG_FILE_PATH="db.config.json";
    final File databaseConfigFile;
    private DatabaseConfigModel databaseConfig;

    public ConfigureDatabaseController(){
        String fullDBConfigFilePath=System.getProperty("user.dir");
        fullDBConfigFilePath=fullDBConfigFilePath+ PathHelper.toCurrentOSPathSyntax("helpers/"+DB_CONFIG_FILE_PATH);
        databaseConfigFile=new File(fullDBConfigFilePath);
    }
    public void saveDatabaseConfigurations(DatabaseConfigModel config){
        databaseConfig =config;

    }


    public boolean isDatabaseConfigured() {
        return false;
    }
}
