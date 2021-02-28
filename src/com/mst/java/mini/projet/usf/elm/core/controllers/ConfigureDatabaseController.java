package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.models.DatabaseConfigModel;

import java.io.File;

public class ConfigureDatabaseController {
    final private String DB_CONFIG_FILE_PATH="/db.config";
    private DatabaseConfigModel databaseConfig;

    public void saveDatabaseConfigurations(DatabaseConfigModel config){
        databaseConfig =config;

    }


}
