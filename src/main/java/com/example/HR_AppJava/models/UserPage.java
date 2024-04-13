package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame {
    private JButton homeButton, userButton, editSaveButton;
    private JTextField userNameText, passwordText, emailText, companyText;

    public UserPage() {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));

        // ImageIcon homeIcon = new ImageIcon("homeIcon.png");
        homeButton = new JButton("Home");
        userButton = new JButton("User");
        editSaveButton = new JButton("Edit");

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel emailLabel = new JLabel("E-Mail: ");
        JLabel companyLabel = new JLabel("Company Name: ");
        JLabel blankLabel = new JLabel("");
        userNameText = new JTextField(LoginPage.getCurrentUser().getUsername());
        passwordText = new JTextField(LoginPage.getCurrentUser().getPassword());
        emailText = new JTextField(LoginPage.getCurrentUser().getEmail());
        companyText = new JTextField(LoginPage.getCurrentUser().getCompany());

        userNameText.setEditable(false);
        passwordText.setEditable(false);
        emailText.setEditable(false);
        companyText.setEditable(false);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomePage();
            }
        });

        editSaveButton.addActionListener(new ActionListener() {
            boolean isClicked = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isClicked) {
                    editSaveButton.setText("Save");
                    userNameText.setEditable(true);
                    passwordText.setEditable(true);
                    emailText.setEditable(true);
                    companyText.setEditable(true);
                    User currentUser = LoginPage.getCurrentUser();
                    currentUser.setUsername(userNameText.getText());
                    currentUser.setPassword(passwordText.getText());
                    currentUser.setEmail(emailText.getText());
                    currentUser.setCompany(companyText.getText());
                } else {
                    editSaveButton.setText("Edit");
                    userNameText.setEditable(false);
                    passwordText.setEditable(false);
                    emailText.setEditable(false);
                    companyText.setEditable(false);
                }
                isClicked = !isClicked;
            }
        });

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

        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new GridLayout(5, 2));
        userInfoPanel.setPreferredSize(new Dimension(400, 200));
        userInfoPanel.add(blankLabel);
        userInfoPanel.add(editSaveButton);
        userInfoPanel.add(usernameLabel);
        userInfoPanel.add(userNameText);
        userInfoPanel.add(passwordLabel);
        userInfoPanel.add(passwordText);
        userInfoPanel.add(emailLabel);
        userInfoPanel.add(emailText);
        userInfoPanel.add(companyLabel);
        userInfoPanel.add(companyText);

        JPanel gluePanel2 = new JPanel(new BorderLayout());
        gluePanel2.add(userInfoPanel, BorderLayout.WEST);
        gluePanel2.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel2.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        mainPanel.add(gluePanel1);
        mainPanel.add(gluePanel2);
        this.getContentPane().add(mainPanel);

        this.pack();
        setVisible(true);

    }
}
