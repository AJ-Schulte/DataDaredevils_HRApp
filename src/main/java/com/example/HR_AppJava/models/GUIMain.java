package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;

public class GUIMain extends JFrame {
    // private JButton homeButton, userButton, createButton, saveButton,
    // deleteButton;
    // private JTextField userCompanyTXT, firstNameTXT, lastNameTXT, addressTXT,
    // phoneNumTXT, emailTXT, currentTeamTXT, formerCompanyTXT, supervisortTXT,
    // lengthOnJobTXT, jobTitleTXT, roleTXT, criticalSkillsTXT, softSkillsTXT,
    // talentsTXT, evaluatingSupervisorTXT, dateOfEvalTXT, mentalStateTXT, notesTXT;

    public GUIMain() {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                User u1 = new User("asa", null, "123", null, false);
                TempArrays.addUser(u1);
                Testing.arrayGen(1);
                new LoginPage();
            }
        });
    }
}
