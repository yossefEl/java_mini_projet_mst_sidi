package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.PrimaryButton;
import com.mst.java.mini.projet.usf.elm.core.views.components.DashAreaTitle;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowClientsView extends MainDashboardContentArea {

    public DefaultTableModel tableModel;
    public JTable table;

    private JRadioButton filterByID;
    private JRadioButton filterByName;
    private JRadioButton filterByBirthday;
    private ButtonGroup filterClientsCheckGroup;

    PrimaryButton refreshFilteredClientsListButton;

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

        refreshFilteredClientsListButton = new PrimaryButton("Ajouter",
                new Rectangle(0, 0, 126, 35),
                AppColors.orangeColor
        );

         filterClientsCheckGroup=new ButtonGroup();

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

        JTableHeader tableHeader=table.getTableHeader();
        tableHeader.setBackground(AppColors.darkGreyColor);
        tableHeader.setBorder(new EmptyBorder(0,0,0,0));
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),30));


        tableModel.addRow(new Object[]{"infos[0]", "infos[1]", "infos[2]"," infos[3]", "infos[4]"});

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBackground(AppColors.whiteColor);
        tableScrollPane.setBounds(23,124,595,getHeight()-124);
        tableScrollPane.setBorder(new EmptyBorder(0,0,0,0));

        add(title);
        add(filtersContainer);
        add(tableScrollPane);

        setVisible(true);


    }

    public void addClientActionListener(ActionListener cientActionListener) {
        refreshFilteredClientsListButton.addActionListener(cientActionListener);

    }

    public PrimaryButton getRefreshFilteredClientsListButton() {
        return refreshFilteredClientsListButton;
    }



}
