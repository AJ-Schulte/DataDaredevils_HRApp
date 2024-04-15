package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JButton loginButton, signUpButton;
    private JTextField usernameTXT;
    private JPasswordField passwordTXT;
    private static int currentUserIndex;

    public LoginPage() {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameTXT = new JTextField();
        passwordTXT = new JPasswordField();

        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");

        // Check if Button was pressed
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTXT.getText();
                char[] password = passwordTXT.getPassword();
                login(username, password);
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // remove previous page and move to new page
                dispose();
                new SignUpPage();
            }
        });

        // Add items onto frame
        add(usernameLabel);
        add(usernameTXT);
        add(passwordLabel);
        add(passwordTXT);
        add(loginButton);
        add(signUpButton);

        // Show frame
        setVisible(true);
    }

    private void login(String username, char[] password) {
        if (TempArrays.doesUserExist(username, password)) {
            // Successfully logged in move to home page
            currentUserIndex = TempArrays.searchForUser(username, password);
            JOptionPane.showMessageDialog(this, "Successfully Logged In");
            dispose();
            new HomePage();
        } else {
            // Failed to login reset page
            JOptionPane.showMessageDialog(this, "User Does Not Exist Try Again");
            passwordTXT.setText("");
            usernameTXT.setText("");
        }
    }

    public static int getCurrentUser() {
        return currentUserIndex;
    }
}