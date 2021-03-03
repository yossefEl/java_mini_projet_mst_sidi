package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.CButton;
import com.mst.java.mini.projet.usf.elm.core.views.components.InputField;
import com.mst.java.mini.projet.usf.elm.core.views.components.InputLabel;
import com.mst.java.mini.projet.usf.elm.core.views.components.TitleLabel;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;
import java.awt.*;

public class ConfigureDatabaseView extends JFrame {

    JLabel appLogo;
    JLabel appLabel;
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

    public ConfigureDatabaseView() {
        buildView();
    }

    private void buildView() {
        setLayout(null);

        //init components
        appLogo = new JLabel(AssetsProvider.fsteLogo150);
        appLogo.setBounds(336, 9, 150, 150);

        appLabel = new TitleLabel("Configurer", "la base données");
        appLabel.setBounds(262, 159, 800, 20);

        serverAddressLabel = new InputLabel("Adresse Serveur",
                new Rectangle(210, 208, 112, 17));
        serverAddressField = new InputField(new Rectangle(344, 198, 260, 35));

        dbNameLabel = new InputLabel("Base données",
                new Rectangle(210, 251, 112, 17));
        dbNameField = new InputField(new Rectangle(344, 242, 260, 35));

        tableNameLabel = new InputLabel("La table",
                new Rectangle(210, 295, 112, 17));
        tableNameField = new InputField(new Rectangle(344, 286, 260, 35));

        dbUsernameLabel = new InputLabel("Utilisateur",
                new Rectangle(210, 338, 112, 17));
        dbUsernameField = new InputField(new Rectangle(344, 330, 260, 35));

        dbPasswordLabel = new InputLabel("Mot de passe",
                new Rectangle(210, 382, 112, 17));
        dbPasswordField = new InputField(new Rectangle(344, 374, 260, 35));

        saveConfigsButton = new CButton("Terminer",
                new Rectangle(210, 424, 394, 35),
                AppColors.blueColor);

        //composing components


        add(appLogo);
        add(appLabel);
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
        setSize(819, 512);
        setLocationRelativeTo(null);
        setVisible(true);


    }

}
