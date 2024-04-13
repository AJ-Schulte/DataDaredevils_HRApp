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
        setPreferredSize(new Dimension(1000, 600));

        // ImageIcon homeIcon = new ImageIcon("homeIcon.png");
        homeButton = new JButton("Home");
        userButton = new JButton("User");
        addData = new JButton("Add");
        editData = new JButton("Edit");

        String[] columnNames = { "Name", "E-Mail", "Phone Number", "Current Team" };
        String[][] demographicsData = new String[TempArrays.getDemographicSize()][4];
        for (int i = 0; i < TempArrays.getDemographicSize(); i++) {
            demographicsData[i][0] = TempArrays.getDemographic(i).getName();
            demographicsData[i][1] = TempArrays.getDemographic(i).getEmail();
            demographicsData[i][2] = TempArrays.getDemographic(i).getPhoneNumber();
            demographicsData[i][3] = TempArrays.getDemographic(i).getCurrentTeam();
        }
        table = new JTable(demographicsData, columnNames);

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserPage();
            }
        });

        // Adding Panes to the Window
        JScrollPane tablePane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(2, 1));
        sidebar.setPreferredSize(new Dimension(80, 160));
        sidebar.add(homeButton);
        sidebar.add(userButton);

        JPanel gluePanel1 = new JPanel(new BorderLayout());
        gluePanel1.add(sidebar, BorderLayout.WEST);
        gluePanel1.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel1.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(2, 1));
        tablePanel.setPreferredSize(new Dimension(800, 200));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.setPreferredSize(new Dimension(200, 100));
        buttonPanel.add(addData);
        buttonPanel.add(editData);

        tablePanel.add(buttonPanel);
        tablePanel.add(tablePane);

        JPanel gluePanel2 = new JPanel(new BorderLayout());
        gluePanel2.add(tablePanel, BorderLayout.WEST);
        gluePanel2.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel2.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        mainPanel.add(gluePanel1);
        mainPanel.add(gluePanel2);
        this.getContentPane().add(mainPanel);

        this.pack();
        setVisible(true);
    }
}
