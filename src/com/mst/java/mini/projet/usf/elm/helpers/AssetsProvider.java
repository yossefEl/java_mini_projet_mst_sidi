package com.mst.java.mini.projet.usf.elm.helpers;


import javax.swing.*;
import java.io.File;

import static com.mst.java.mini.projet.usf.elm.helpers.PathHelper.PROJECT_ASSETS_PATH;
/*
* @author Youssef ELMOUMEN
* this class is the handler of this project's assets
* the purpose behind it is minimizing the memory usage by declaring all reusable resources
* only one time and also for refactoring the code
 */
public class AssetsProvider {
    //db.config contains our database connection credentials
    public final static File dbConfigFile = new File(
            PROJECT_ASSETS_PATH + "db.config");
    public final static ImageIcon fsteLogo78 = new ImageIcon(
            PROJECT_ASSETS_PATH + "fste_78.png");
    public final static ImageIcon fsteLogo150 = new ImageIcon(
            PROJECT_ASSETS_PATH + "fste_150.png");

    public final static ImageIcon loadingImage45 = new ImageIcon(
            PROJECT_ASSETS_PATH + "loader45px.gif");


}
