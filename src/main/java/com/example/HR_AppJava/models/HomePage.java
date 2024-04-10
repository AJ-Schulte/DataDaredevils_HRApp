package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JButton homeButton, userButton, addData, editData;
    private JTable table;

    public HomePage() {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new GridLayout(1, 2, 10, 10));

        ImageIcon homeIcon = new ImageIcon("homeIcon.png");
        homeButton = new JButton(homeIcon);
        homeButton.setSize(970, 970);
        userButton = new JButton("User Page");
        addData = new JButton("Add");
        /*
         * String[] columnNames = { "Name", "E-Mail", "Phone Number", "Current Team" };
         * String[][] data;
         * for (int i = 0; i < TempArrays.getDemographicSize(); i++) {
         * EmployeeDemographics employee = TempArrays.getDemographic(i);
         * data+={employee.getName(),employee.getEmail(),employee.getPhoneNumber(),
         * employee.getCurrentTeam()};
         * }
         */

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 1));
        mainPanel.add(addData);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(2, 1));
        sidebar.setBounds(0, 0, 200, 600);
        sidebar.add(homeButton);
        sidebar.add(userButton);

        add(sidebar);
        add(mainPanel);

        setVisible(true);
    }
}
