package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.InputField;
import com.mst.java.mini.projet.usf.elm.core.views.components.InputLabel;
import com.mst.java.mini.projet.usf.elm.core.views.components.PrimaryButton;
import com.mst.java.mini.projet.usf.elm.core.views.components.TitleLabel;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfigureDatabaseView extends JPanel {

    private JLabel appLogo;
    private JLabel appLabel;
    private JLabel loadingLabel;
    private JLabel serverAddressLabel;
    private JTextField serverAddressField;
    private JLabel dbNameLabel;
    private JTextField dbNameField;
    private JLabel tableNameLabel;
    private JTextField tableNameField;
    private JLabel dbUsernameLabel;
    private JTextField dbUsernameField;
    private JLabel dbPasswordLabel;
    private JTextField dbPasswordField;
    private JButton saveConfigsButton;


    /// controllers


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

        saveConfigsButton = new PrimaryButton("Terminer",
                new Rectangle(210, 424, 394, 35),
                AppColors.blueColor);


        loadingLabel = new JLabel(AssetsProvider.loadingImage45, SwingConstants.CENTER);
        loadingLabel.setBounds(210, 424, 394, 45);
        loadingLabel.setVisible(false);

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
        add(loadingLabel);
        setSize(819, 512);

        setVisible(true);


    }

    /**
     * add an action listeners to the save configurations button
     *
     * @param listener OnSaveConfigActionListener
     */
    public void addOnSaveConfigActionListener(ActionListener listener) {
        saveConfigsButton.addActionListener(listener);
    }



    //getters and setters

    public JLabel getLoadingLabel() {
        return loadingLabel;
    }

    public String getServerAddress() {
        return serverAddressField.getText();
    }


    public String getDBName() {
        return dbNameField.getText();
    }


    public String getTableName() {
        return tableNameField.getText();
    }


    public String getDbUsername() {
        return dbUsernameField.getText();
    }


    public String getDbPassword() {
        return dbPasswordField.getText();
    }

    public JButton getSaveConfigsButton() {
        return saveConfigsButton;
    }


}
