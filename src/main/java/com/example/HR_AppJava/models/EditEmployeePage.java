package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EditEmployeePage extends JFrame {
    private JPanel demographicsPanel, jobHistoryPanel, evaluationPanel;
    private JButton saveButton;
    private JLabel demographicLabel, nameLabel, addressLabel, emailLabel, phoneNumLabel, currentTeamLabel,
            jobHistoryLabel, companyNameLabel, supervisorLabel, lengthLabel, jobTitleLabel, roleOnTeamLabel,
            critSkillsLabel, softSkillsLabel, talentsLabel, employeeEvalLabel, dateOfEvalLabel, mentalStateLabel,
            notesLabel,
            evaluatingSupervisorLabel;
    private JTextField nameTextField, addressTextField, emailTextField, phoneNumTextField, currentTeamTextField,
            companyNameTextField, supervisorTextField, jobTitleTextField, roleOnTeamTextField, mentalStateTextField,
            evaluatingSupervisorTextField;
    private JTextArea critSkillsArea, softSkillsArea, talentsArea, notesArea;
    private JSpinner lengthSpinner, dateOfEvalSpinner;

    public EditEmployeePage(EmployeeDemographics employee) {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 600));

        ArrayList<EmployeeJobHistory> jobHistories = TempArrays.getAllJobHistories(employee.getMemberID());
        ArrayList<EmployeeEvaluation> evaluations = TempArrays.getAllEvaluations(employee.getMemberID());

        saveButton = new JButton("Save");

        // Label Initializations
        demographicLabel = new JLabel("Employee Demographics: ");
        nameLabel = new JLabel("Name: ");
        addressLabel = new JLabel("Address: ");
        emailLabel = new JLabel("E-Mail: ");
        phoneNumLabel = new JLabel("Phone Number: ");
        currentTeamLabel = new JLabel("Current Team: ");
        jobHistoryLabel = new JLabel("Job History: ");
        companyNameLabel = new JLabel("Company Name: ");
        supervisorLabel = new JLabel("Former Supervisor: ");
        lengthLabel = new JLabel("Length on Job (in months): ");
        jobTitleLabel = new JLabel("Job Title: ");
        roleOnTeamLabel = new JLabel("Role On Team: ");
        critSkillsLabel = new JLabel("Critical Skills: ");
        softSkillsLabel = new JLabel("Soft Skills: ");
        talentsLabel = new JLabel("Talents: ");
        employeeEvalLabel = new JLabel("Employee Evaluations: ");
        dateOfEvalLabel = new JLabel("Date of Evaluation: ");
        mentalStateLabel = new JLabel("Mental State: ");
        notesLabel = new JLabel("Notes: ");
        evaluatingSupervisorLabel = new JLabel("Evaluating Supervisor: ");

        // Text Area Initializations
        nameTextField = new JTextField(employee.getName());
        addressTextField = new JTextField(employee.getAddress());
        emailTextField = new JTextField(employee.getEmail());
        phoneNumTextField = new JTextField(employee.getPhoneNumber());
        currentTeamTextField = new JTextField(employee.getCurrentTeam());
        companyNameTextField = new JTextField();
        supervisorTextField = new JTextField();
        jobTitleTextField = new JTextField();
        roleOnTeamTextField = new JTextField();
        critSkillsArea = new JTextArea();
        softSkillsArea = new JTextArea();
        talentsArea = new JTextArea();
        mentalStateTextField = new JTextField();
        notesArea = new JTextArea();
        evaluatingSupervisorTextField = new JTextField();

        // Spinner Set-Up
        SpinnerNumberModel numberModel = new SpinnerNumberModel(0, 0, 10000, 1);
        lengthSpinner = new JSpinner(numberModel);
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();
        SpinnerDateModel dateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);
        dateOfEvalSpinner = new JSpinner(dateModel);

        // Job History Panel
        jobHistoryPanel = new JPanel();
        jobHistoryPanel.setLayout(new GridLayout(9, 2));
        jobHistoryPanel.setPreferredSize(new Dimension(1000, 600));
        jobHistoryPanel.add(jobHistoryLabel);
        jobHistoryPanel.add(new JLabel());
        for (int i = 0; i < jobHistories.size(); i++) {
            jobHistoryPanel.add(companyNameLabel);
            companyNameTextField.setText(jobHistories.get(i).getCompanyName());
            jobHistoryPanel.add(companyNameTextField);
            jobHistoryPanel.add(supervisorLabel);
            supervisorTextField.setText(jobHistories.get(i).getSupervisor());
            jobHistoryPanel.add(supervisorTextField);
            jobHistoryPanel.add(lengthLabel);
            lengthSpinner.setValue(jobHistories.get(i).getLengthOnJob());
            jobHistoryPanel.add(lengthSpinner);
            jobHistoryPanel.add(jobTitleLabel);
            jobTitleTextField.setText(jobHistories.get(i).getJobTitle());
            jobHistoryPanel.add(jobTitleTextField);
            jobHistoryPanel.add(roleOnTeamLabel);
            roleOnTeamTextField.setText(jobHistories.get(i).getRoleOnTeam());
            jobHistoryPanel.add(roleOnTeamTextField);
            jobHistoryPanel.add(critSkillsLabel);
            critSkillsArea.setText(jobHistories.get(i).getCriticalSkills());
            jobHistoryPanel.add(critSkillsArea);
            jobHistoryPanel.add(softSkillsLabel);
            softSkillsArea.setText(jobHistories.get(i).getSoftSkills());
            jobHistoryPanel.add(softSkillsArea);
            jobHistoryPanel.add(talentsLabel);
            talentsArea.setText(jobHistories.get(i).getTalents());
            jobHistoryPanel.add(talentsArea);
        }

        // Employee Evaluations
        evaluationPanel = new JPanel();
        evaluationPanel.setLayout(new GridLayout(6, 2));
        evaluationPanel.setPreferredSize(new Dimension(1000, 600));
        evaluationPanel.add(employeeEvalLabel);
        evaluationPanel.add(new JLabel());
        for (int i = 0; i < evaluations.size(); i++) {
            evaluationPanel.add(dateOfEvalLabel);
            dateOfEvalSpinner.setValue(evaluations.get(i).getDateofEval());
            evaluationPanel.add(dateOfEvalSpinner);
            evaluationPanel.add(mentalStateLabel);
            mentalStateTextField.setText(evaluations.get(i).getMentalstate());
            evaluationPanel.add(mentalStateTextField);
            evaluationPanel.add(evaluatingSupervisorLabel);
            evaluatingSupervisorTextField.setText(evaluations.get(i).getEvaluatingSupervisor());
            evaluationPanel.add(evaluatingSupervisorTextField);
            evaluationPanel.add(notesLabel);
            notesArea.setText(evaluations.get(i).getEmployeenotes());
            evaluationPanel.add(notesArea);
        }
        evaluationPanel.add(new JLabel());
        evaluationPanel.add(saveButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane jobHistoryScroller = new JScrollPane(mainPanel);

        // Demographics Panel
        demographicsPanel = new JPanel();
        demographicsPanel.setLayout(new GridLayout(6, 2));
        demographicsPanel.setPreferredSize(new Dimension(800, 160));
        demographicsPanel.add(demographicLabel);
        demographicsPanel.add(new JLabel());
        demographicsPanel.add(nameLabel);
        demographicsPanel.add(nameTextField);
        demographicsPanel.add(addressLabel);
        demographicsPanel.add(addressTextField);
        demographicsPanel.add(phoneNumLabel);
        demographicsPanel.add(phoneNumTextField);
        demographicsPanel.add(emailLabel);
        demographicsPanel.add(emailTextField);
        demographicsPanel.add(currentTeamLabel);
        demographicsPanel.add(currentTeamTextField);

        // Glue Panels
        JPanel gluePanel1 = new JPanel(new BorderLayout());
        gluePanel1.add(demographicsPanel, BorderLayout.WEST);
        gluePanel1.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel1.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        JPanel gluePanel2 = new JPanel(new BorderLayout());
        gluePanel2.add(jobHistoryPanel, BorderLayout.WEST);
        gluePanel2.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel2.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        JPanel gluePanel3 = new JPanel(new BorderLayout());
        gluePanel3.add(evaluationPanel, BorderLayout.WEST);
        gluePanel3.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
        gluePanel3.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        mainPanel.add(gluePanel1);
        mainPanel.add(gluePanel2);
        mainPanel.add(gluePanel3);
        this.getContentPane().add(jobHistoryScroller);

        this.pack();
        setVisible(true);
    }
}
