package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.ConfigureDatabaseController;
import javax.swing.*;

public class HomeView extends JFrame {
    HomeView(){
        final ConfigureDatabaseController configureDatabaseController=new ConfigureDatabaseController();
        configureDatabaseController.isDatabaseConfigured();

    }
}
