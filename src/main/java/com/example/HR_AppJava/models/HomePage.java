package com.example.HR_AppJava.models;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HomePage extends JFrame {
    private JButton homeButton, userButton, addData, editData, searchButton;
    private JTable table;
    private JTextField searchBox;

    public HomePage() {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));

        // ImageIcon homeIcon = new ImageIcon("homeIcon.png");
        homeButton = new JButton("Home");
        userButton = new JButton("User");
        addData = new JButton("Add");
        editData = new JButton("Edit");
        searchButton = new JButton("Search");

        searchBox = new JTextField("Enter Name of Employee Here");

        // Creates the table of employees
        String[] columnNames = { "ID", "Name", "E-Mail", "Phone Number", "Current Team" };
        String[][] demographicsData = new String[TempArrays.getDemographicSize()][5];
        for (int i = 0; i < TempArrays.getDemographicSize(); i++) {
            Integer memberID = TempArrays.getDemographic(i).getMemberID();
            demographicsData[i][0] = memberID.toString();
            demographicsData[i][1] = TempArrays.getDemographic(i).getName();
            demographicsData[i][2] = TempArrays.getDemographic(i).getEmail();
            demographicsData[i][3] = TempArrays.getDemographic(i).getPhoneNumber();
            demographicsData[i][4] = TempArrays.getDemographic(i).getCurrentTeam();
        }
        table = new JTable();
        table.setSelectionMode(0); // Make user only able to select 1 Employee at a time
        DefaultTableModel tableModel = new DefaultTableModel(demographicsData, columnNames) {
            // Prevent User from Editing cells directly in table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(tableModel);

        // Action listeners
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserPage();
            }
        });

        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeDemographics newEmployee = new EmployeeDemographics(null, null, null, null, null);
                TempArrays.addDemographic(newEmployee);
                new AddEmployeePage(newEmployee);
            }
        });

        editData.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    int column = 0;
                    int row = table.getSelectedRow();
                    int value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
                    try {
                        new EditEmployeePage(TempArrays.searchDemographic(value));
                    } catch (Exception e1) {
                        // TODO: Auto-generated this catch block. This needs to handle the case where searchDemographic() can't find a matching object.
                        e1.printStackTrace();
                    }
                } else {
                    unselected();
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = searchBox.getText();
                int i;
                for (i = 0; i < TempArrays.getDemographicSize(); i++) {
                    if (TempArrays.getDemographic(i).getName().equals(name)) {
                        break;
                    }
                }
                if (i >= TempArrays.getDemographicSize())
                    JOptionPane.showMessageDialog(null, "Employee Does Not Exist");
                else if (TempArrays.getDemographic(i).getName().equals(name)) {
                    try {
                        new EditEmployeePage(TempArrays.searchDemographic(i));
                    } catch (Exception e1) {
                        // TODO: Auto-generated this catch block. This needs to handle the case where searchDemographic() can't find a matching object.
                        e1.printStackTrace();
                    }
                    searchBox.setText("Enter Name of Employee Here");
                }
            }
        });

        searchBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchBox.getText().equals("Enter Name of Employee Here"))
                    searchBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchBox.getText().isEmpty())
                    searchBox.setText("Enter Name of Employee Here");
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
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.setPreferredSize(new Dimension(200, 100));
        buttonPanel.add(addData);
        buttonPanel.add(editData);
        buttonPanel.add(searchBox);
        buttonPanel.add(searchButton);

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

    private void unselected() {
        JOptionPane.showMessageDialog(this, "No Employee Selected. Try Again");
    }
}
