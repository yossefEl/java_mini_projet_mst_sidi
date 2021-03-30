package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.DashAreaTitle;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.PrimaryButton;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowClientsView extends MainDashboardContentArea {

    PrimaryButton refreshFilteredClientsListButton;
    private DefaultTableModel tableModel;
    private JTable table;
    private JRadioButton filterByID;
    private JRadioButton filterByName;
    private JRadioButton filterByBirthday;
    private ButtonGroup filterClientsCheckGroup;

    public ShowClientsView() {
        buildView();
    }

    private void buildView() {


        title = new DashAreaTitle(new Rectangle(224, 26, 300, 17), "Afficher Les clients");

        JPanel filtersContainer = new JPanel(new FlowLayout());
        filtersContainer.setBounds(23, 72, getWidth(), 35);
        filtersContainer.setBackground(AppColors.whiteColor);

        JLabel sortLabel = new JLabel("Trier par: ");
        sortLabel.setFont(new Font("Arial", Font.BOLD, 18));
        sortLabel.setForeground(AppColors.blueColor);

        filterByID = new JRadioButton("Num", false);
        filterByName = new JRadioButton("Nom", false);
        filterByBirthday = new JRadioButton("Date naissance", false);

        refreshFilteredClientsListButton = new PrimaryButton("Actualiser",
                new Rectangle(0, 0, 126, 35),
                AppColors.orangeColor
        );

        filterClientsCheckGroup = new ButtonGroup();

        filterClientsCheckGroup.add(filterByID);
        filterClientsCheckGroup.add(filterByName);
        filterClientsCheckGroup.add(filterByBirthday);

        filtersContainer.add(sortLabel);
        filtersContainer.add(filterByID);
        filtersContainer.add(filterByName);
        filtersContainer.add(filterByBirthday);
        filtersContainer.add(refreshFilteredClientsListButton);


        String[] columnNames = new String[]{"Numero", "Nom", "Prénom", "Date de naissance", "Adresse"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(AppColors.darkGreyColor);
        tableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));


        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBackground(AppColors.whiteColor);
        tableScrollPane.setBounds(23, 124, 595, getHeight() - 124);
        tableScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        add(title);
        add(filtersContainer);
        add(tableScrollPane);

        setVisible(true);


    }

    /**
     * adds an action listeners to the clickable elements in this view
     *
     * @param clientActionListener comes from the ClientController
     */
    public void addClientActionListener(ActionListener clientActionListener) {
        refreshFilteredClientsListButton.addActionListener(clientActionListener);

    }


    //getters and setters

    public PrimaryButton getRefreshFilteredClientsListButton() {
        return refreshFilteredClientsListButton;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public ButtonGroup getFilterClientsCheckGroup() {
        return filterClientsCheckGroup;
    }


}
