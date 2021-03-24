package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.*;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;
import java.awt.*;

public class UpdateDBConfigView extends MainDashboardContentArea {

    JLabel serverAddressLabel;
    JTextField serverAddressField;
    JLabel dbNameLabel;
    JTextField dbNameField;
    JLabel tableNameLabel;
    JTextField tableNameField;
    JLabel dbUsernameLabel;
    JTextField dbUsernameField;
    JLabel dbPasswordLabel;
    JTextField dbPasswordField;
    JButton saveConfigsButton;
    CButton cancelButton;

    public UpdateDBConfigView() {
        buildView();
    }

    private void buildView() {
        //init components

        title=new DashAreaTitle(new Rectangle(186,26,350,17),"Configurer la base données");
        serverAddressLabel = new InputLabel("Adresse Serveur",
                new Rectangle(122, 73, 112, 17));
        serverAddressField = new InputField(new Rectangle(256, 63, 260, 35));

        dbNameLabel = new InputLabel("Base données",
                new Rectangle(122, 116, 112, 17));
        dbNameField = new InputField(new Rectangle(256, 107, 260, 35));

        tableNameLabel = new InputLabel("La table",
                new Rectangle(122, 160, 112, 17));
        tableNameField = new InputField(new Rectangle(256, 151, 260, 35));

        dbUsernameLabel = new InputLabel("Utilisateur",
                new Rectangle(122, 203, 112, 17));
        dbUsernameField = new InputField(new Rectangle(256, 195, 260, 35));

        dbPasswordLabel = new InputLabel("Mot de passe",
                new Rectangle(122, 247, 112, 17));
        dbPasswordField = new InputField(new Rectangle(256, 239, 260, 35));



        saveConfigsButton = new CButton("Modifier",
                new Rectangle(390, 286, 126, 35),
                AppColors.blueColor
        );
        cancelButton = new CButton("Annuler",
                new Rectangle(256, 286, 126, 35),
                AppColors.redColor
        );

        //composing components

        add(title);
        add(serverAddressLabel);
        add(serverAddressField);
        add(dbNameLabel);
        add(dbNameField);
        add(tableNameLabel);
        add(tableNameField);
        add(dbUsernameLabel);
        add(dbUsernameField);
        add(dbPasswordLabel);
        add(dbPasswordField);
        add(saveConfigsButton);
        add(cancelButton);

        setVisible(true);

    }
}
