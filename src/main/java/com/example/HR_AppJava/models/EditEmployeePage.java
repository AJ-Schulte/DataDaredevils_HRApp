/*
 * This is the page that pops up when you click "Edit" from the Home page.
 * TODO: Refresh to show added JobHistory/EmployeeEvaluation objects
 */

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
    private JButton saveButton, addHistoryButton, addEvaluationButton;
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

    public EditEmployeePage(EmployeeDemographics employee) throws Exception{
        final int memberID = employee.getMemberID();
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 600));

        ArrayList<EmployeeJobHistory> jobHistories = TempArrays.getAllJobHistories(memberID);
        ArrayList<EmployeeEvaluation> evaluations = TempArrays.getAllEvaluations(memberID);

        saveButton = new JButton("Save");
        addHistoryButton = new JButton("New Job History");
        addEvaluationButton = new JButton("New Evaluation");

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

        // Spinner Set-Ups
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

        // Buttons that need to do actions
        // Save Button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TempArrays.setDemographic(memberID, nameTextField.getText(), addressTextField.getText(), phoneNumTextField.getText(), emailTextField.getText(), currentTeamTextField.getText());

                EmployeeJobHistory editedJobHist = new EmployeeJobHistory(companyNameTextField.getText(), supervisorTextField.getText(), lengthSpinner.getValue().hashCode(), jobTitleTextField.getText(), roleOnTeamTextField.getText(), memberID);
                editedJobHist.setCriticalSkills(critSkillsArea.getText());
                editedJobHist.setSoftSkills(softSkillsArea.getText());
                editedJobHist.setTalents(talentsArea.getText());
                TempArrays.setJobHistory(memberID, editedJobHist);

                /*//This does not appear to work and I have no idea why. 
                Date testdate = new Date(dateOfEvalSpinner.getValue().hashCode()); //testing
                System.out.println(testdate); //testing
                EmployeeEvaluation test = new EmployeeEvaluation(evaluatingSupervisorTextField.getText(), testdate, mentalStateTextField.getText(), notesArea.getText(), memberID);
                TempArrays.setEmployeeEvaluation(memberID, test);
                dispose(); */
            }
        });

        // Create a new EmployeeJobHistory object that is connected to this employee
        addHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a Pop-up window that allows user to enter info for job history that
                // needs to be added to database then dispose pop-up
                JFrame addHistoryFrame = new JFrame();
                addHistoryFrame.setTitle("HR App");
                addHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addHistoryFrame.setPreferredSize(new Dimension(500, 600));

                JButton addHistoryButton = new JButton("Create");

                JTextField companyNameTextField2, supervisorTextField2, jobTitleTextField2, roleOnTeamTextField2;
                companyNameTextField2 = new JTextField();
                supervisorTextField2 = new JTextField();
                jobTitleTextField2 = new JTextField();
                roleOnTeamTextField2 = new JTextField();

                JTextArea critSkillsArea2, softSkillsArea2, talentsArea2;
                critSkillsArea2 = new JTextArea();
                softSkillsArea2 = new JTextArea();
                talentsArea2 = new JTextArea();

                SpinnerNumberModel numberModel2 = new SpinnerNumberModel(0, 0, 10000, 1);
                JSpinner lengthSpinner2 = new JSpinner(numberModel2);

                addHistoryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EmployeeJobHistory addedJobHist = new EmployeeJobHistory(companyNameTextField2.getText(), supervisorTextField2.getText(), lengthSpinner2.getValue().hashCode(), jobTitleTextField2.getText(), roleOnTeamTextField2.getText(), memberID);
                        addedJobHist.setCriticalSkills(critSkillsArea.getText());
                        addedJobHist.setSoftSkills(softSkillsArea.getText());
                        addedJobHist.setTalents(talentsArea.getText());
                        TempArrays.addJobHistoryAt(memberID, addedJobHist);
                        addHistoryFrame.dispose();
                    }
                });

                JPanel historyPanel = new JPanel();
                historyPanel.setLayout(new GridLayout(9, 2));
                historyPanel.add(companyNameLabel);
                historyPanel.add(companyNameTextField2);
                historyPanel.add(supervisorLabel);
                historyPanel.add(supervisorTextField2);
                historyPanel.add(lengthLabel);
                historyPanel.add(lengthSpinner2);
                historyPanel.add(jobTitleLabel);
                historyPanel.add(jobTitleTextField2);
                historyPanel.add(roleOnTeamLabel);
                historyPanel.add(roleOnTeamTextField2);
                historyPanel.add(critSkillsLabel);
                historyPanel.add(critSkillsArea2);
                historyPanel.add(softSkillsLabel);
                historyPanel.add(softSkillsArea2);
                historyPanel.add(talentsLabel);
                historyPanel.add(talentsArea2);
                historyPanel.add(new JLabel());
                historyPanel.add(addHistoryButton);

                JPanel historyGluePanel = new JPanel(new BorderLayout());
                historyGluePanel.add(historyPanel, BorderLayout.WEST);
                historyGluePanel.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
                historyGluePanel.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

                addHistoryFrame.add(historyGluePanel);
                addHistoryFrame.pack();
                addHistoryFrame.setVisible(true);
            }
        });

        // Create a new evaluation object connected to this employee
        addEvaluationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a pop-up window that allows user to enter info for evaluation which
                // needs to be added to database then dispose pop-up
                JFrame evaluationFrame = new JFrame();
                evaluationFrame.setTitle("HR App");
                evaluationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                evaluationFrame.setPreferredSize(new Dimension(500, 600));

                JButton evaluationButton = new JButton("Create");

                JTextField mentalStateTextField2, evaluatingSupervisorTextField2;
                mentalStateTextField2 = new JTextField();
                evaluatingSupervisorTextField2 = new JTextField();

                JTextArea notesArea2 = new JTextArea();

                Calendar calendar2 = Calendar.getInstance();
                Date initDate2 = calendar2.getTime();
                calendar2.add(Calendar.YEAR, -100);
                Date earliestDate2 = calendar2.getTime();
                calendar2.add(Calendar.YEAR, 200);
                Date latestDate2 = calendar2.getTime();
                SpinnerDateModel dateModel2 = new SpinnerDateModel(initDate2, earliestDate2, latestDate2,
                        Calendar.YEAR);
                JSpinner dateOfEvalSpinner2 = new JSpinner(dateModel2);

                evaluationButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EmployeeEvaluation test = new EmployeeEvaluation(evaluatingSupervisorTextField2.getText(), new Date(dateOfEvalSpinner2.getValue().hashCode()), mentalStateTextField2.getText(), notesArea2.getText(), memberID);
                        TempArrays.addToEmployeeEvaluationAt(memberID, test);
                        evaluationFrame.dispose();
                    }
                });

                JPanel evaluationsPanel = new JPanel();
                evaluationsPanel.setLayout(new GridLayout(5, 2));
                evaluationsPanel.add(dateOfEvalLabel);
                evaluationsPanel.add(dateOfEvalSpinner2);
                evaluationsPanel.add(mentalStateLabel);
                evaluationsPanel.add(mentalStateTextField2);
                evaluationsPanel.add(evaluatingSupervisorLabel);
                evaluationsPanel.add(evaluatingSupervisorTextField2);
                evaluationsPanel.add(notesLabel);
                evaluationsPanel.add(notesArea2);
                evaluationsPanel.add(new JLabel());
                evaluationsPanel.add(evaluationButton);

                JPanel evaulationsGluePanel = new JPanel(new BorderLayout());
                evaulationsGluePanel.add(evaluationsPanel, BorderLayout.WEST);
                evaulationsGluePanel.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
                evaulationsGluePanel.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

                evaluationFrame.add(evaulationsGluePanel);
                evaluationFrame.pack();
                evaluationFrame.setVisible(true);
            }
        });

        // Start of the Panel Creations
        // Creation of main panel and scroll pane (so that page can scroll)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane jobHistoryScroller = new JScrollPane(mainPanel);

        // Job History Panel
        jobHistoryPanel = new JPanel();
        jobHistoryPanel.setLayout(new GridLayout(10, 2));
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
        jobHistoryPanel.add(new JLabel());
        jobHistoryPanel.add(addHistoryButton);

        // Employee Evaluations
        evaluationPanel = new JPanel();
        evaluationPanel.setLayout(new GridLayout(7, 2));
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
        evaluationPanel.add(new JPanel());
        evaluationPanel.add(addEvaluationButton);
        evaluationPanel.add(new JLabel());
        evaluationPanel.add(saveButton);

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

        // Glue Panels so that the formatting is correct
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

        this.getContentPane().add(jobHistoryScroller);
        mainPanel.add(gluePanel1);
        mainPanel.add(gluePanel2);
        mainPanel.add(gluePanel3);

        // Sets scroll pane back to the top of the panel
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jobHistoryScroller.getViewport().setViewPosition(new Point(0, 0));
            }
        });

        this.pack();
        setVisible(true);
    }
}