package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeePage extends JFrame {
    private JPanel demographicsPanel, jobHistoryPanel, evaluationPanel;
    private JLabel demographicLabel, nameLabel, addressLabel, emailLabel, phoneNumLabel, currentTeamLabel,
            jobHistoryLabel, companyNameLabel, supervisorLabel, lengthLabel, jobTitleLabel, roleOnTeamLabel,
            critSkillsLabel, softSkillsLabel, talentsLabel, dateOfEvalLabel, mentalStateLabel, notesLabel,
            evaluatingSupervisorLabel;
    private JTextField nameTextField, addressTextField, emailTextField, phoneNumTextField, currentTeamTextField,
            companyNameTextField, supervisorTextField, jobTitleTextField, roleOnTeamTextField, mentalStateTextField,
            evaluatingSupervisorTextField;
    private JTextArea critSkillsArea, softSkillsArea, talentsArea, notesArea;
    private JSpinner lengthSpinner, dateOfEvalSpinner;

    public EmployeePage(EmployeeDemographics employee) {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(2, 1));
        sidebar.setPreferredSize(new Dimension(80, 160));

        JPanel gluePanel1 = new JPanel(new BorderLayout());
        gluePanel1.add(sidebar, BorderLayout.WEST);
        gluePanel1.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel1.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        mainPanel.add(gluePanel1);
        this.getContentPane().add(mainPanel);

        this.pack();
        setVisible(true);
    }
}
