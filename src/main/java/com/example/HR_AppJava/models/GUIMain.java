package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain extends JFrame {
    // private JButton homeButton, userButton, createButton, saveButton,
    // deleteButton;
    // private JTextField userCompanyTXT, firstNameTXT, lastNameTXT, addressTXT,
    // phoneNumTXT, emailTXT, currentTeamTXT, formerCompanyTXT, supervisortTXT,
    // lengthOnJobTXT, jobTitleTXT, roleTXT, criticalSkillsTXT, softSkillsTXT,
    // talentsTXT, evaluatingSupervisorTXT, dateOfEvalTXT, mentalStateTXT, notesTXT;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                User u1 = new User();
                u1.setUsername("asa");
                TempArrays.addUser(u1);
                new LoginPage();
            }
        });
    }
}
