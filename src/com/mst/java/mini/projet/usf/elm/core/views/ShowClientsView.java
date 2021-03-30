package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.DashAreaTitle;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.PrimaryButton;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowClientsView extends MainDashboardContentArea {

    PrimaryButton refreshClientsListButton;
    private DefaultTableModel tableModel;
    private JTable table;
    private JRadioButton sortByID;
    private JRadioButton sortByName;
    private JRadioButton sortByBirthday;
    private ButtonGroup sortClientsCheckGroup;

    public ShowClientsView() {
        buildView();
    }

    private void buildView() {


        title = new DashAreaTitle(new Rectangle(224, 26, 300, 17), "Afficher Les clients");

        JPanel sortsContainer = new JPanel(new FlowLayout());
        sortsContainer.setBounds(23, 72, getWidth(), 35);
        sortsContainer.setBackground(AppColors.whiteColor);

        JLabel sortLabel = new JLabel("Trier par: ");
        sortLabel.setFont(new Font("Arial", Font.BOLD, 18));
        sortLabel.setForeground(AppColors.blueColor);

        sortByID = new JRadioButton("Num", false);
        sortByID.setBackground(Color.white);
        sortByName = new JRadioButton("Nom", false);
        sortByName.setBackground(Color.white);
        sortByBirthday = new JRadioButton("Date naissance", false);
        sortByBirthday.setBackground(Color.white);

        refreshClientsListButton = new PrimaryButton("Actualiser",
                new Rectangle(0, 0, 126, 35),
                AppColors.orangeColor
        );

        sortClientsCheckGroup = new ButtonGroup();

        sortClientsCheckGroup.add(sortByID);
        sortClientsCheckGroup.add(sortByName);
        sortClientsCheckGroup.add(sortByBirthday);

        sortsContainer.add(sortLabel);
        sortsContainer.add(sortByID);
        sortsContainer.add(sortByName);
        sortsContainer.add(sortByBirthday);
        sortsContainer.add(refreshClientsListButton);


        String[] columnNames = new String[]{"Numero", "Nom", "Prénom", "Date de naissance", "Adresse"};
        tableModel = new DefaultTableModel(columnNames, 0)  {
            @Override
            public Class getColumnClass(int column) {
                if (column == 0) {
                    return Integer.class;
                }
                return String.class;
            }
        };



        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer NumberLeftRenderer = new DefaultTableCellRenderer();
        NumberLeftRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(0).setCellRenderer(NumberLeftRenderer);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(AppColors.darkGreyColor);
        tableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));


        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBackground(AppColors.whiteColor);
        tableScrollPane.setBounds(23, 124, 595, getHeight() - 124);
        tableScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        add(title);
        add(sortsContainer);
        add(tableScrollPane);

        setVisible(true);


    }

    /**
     * adds an action listeners to the clickable elements in this view
     *
     * @param clientActionListener comes from the ClientController
     */
    public void addClientActionListener(ActionListener clientActionListener) {
        refreshClientsListButton.addActionListener(clientActionListener);
        sortByID.addActionListener(clientActionListener);
        sortByName.addActionListener(clientActionListener);
        sortByBirthday.addActionListener(clientActionListener);


    }


    //getters and setters

    public PrimaryButton getRefreshClientsListButton() {
        return refreshClientsListButton;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public ButtonGroup getSortClientsCheckGroup() {
        return sortClientsCheckGroup;
    }

    public JRadioButton getSortByBirthday() {
        return sortByBirthday;
    }

    public JRadioButton getSortByID() {
        return sortByID;
    }

    public JRadioButton getSortByName() {
        return sortByName;
    }
}
