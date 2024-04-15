package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JFrame {
    private JButton createUserButton;
    private JTextField userTXT;
    private JPasswordField passwordTXT;

    public SignUpPage() {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        userTXT = new JTextField();
        passwordTXT = new JPasswordField();

        createUserButton = new JButton("Sign Up");

        // Check if button pressed
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creates a new user
                String username = userTXT.getText();
                char[] password = passwordTXT.getPassword();
                signUp(username, password);
            }
        });

        // Add items to frame
        add(usernameLabel);
        add(userTXT);
        add(passwordLabel);
        add(passwordTXT);
        add(createUserButton);

        // make frame visible
        setVisible(true);
    }

    private void signUp(String username, char[] password) {
        // creates new user with details provided and automatically moves to login page
        User newUser = new User(username, null, String.valueOf(password), null, false);
        TempArrays.addUser(newUser);
        JOptionPane.showMessageDialog(this, "Successfully Created a New Account");
        new LoginPage();
        dispose();
    }
}