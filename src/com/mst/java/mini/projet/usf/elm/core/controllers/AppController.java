package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.views.ConfigureDatabaseView;
import com.mst.java.mini.projet.usf.elm.core.views.DashboardView;
import com.mst.java.mini.projet.usf.elm.core.views.HomeView;
import com.mst.java.mini.projet.usf.elm.core.views.LoginView;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import java.sql.SQLException;

public class AppController {


    private DashboardView dashboardView;
    private LoginView loginView;
    private ConfigureDatabaseView configureDatabaseView;
    private HomeView homeView;

    //controllers
    private DBHelper dbHelper;
    private AuthController authController;





    public AppController(){

         dashboardView=new DashboardView();
         loginView=new LoginView();
         configureDatabaseView=new ConfigureDatabaseView();
         homeView=new HomeView(dashboardView,loginView,configureDatabaseView);

        //
        dbHelper=new DBHelper();
        authController=new  AuthController(loginView,homeView);
    }



    public  void start(){
        try {
            if (dbHelper.isDatabaseConfigured()) {
                if (authController.getAdmin().isLogged()) {
                    homeView.showContent(dashboardView);
                } else {
                    homeView.showContent(loginView);
                }
            } else {
                homeView.showContent(configureDatabaseView);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            DialogHelper.showErrorMessage(homeView,exception.getMessage());
        }
    }
}
