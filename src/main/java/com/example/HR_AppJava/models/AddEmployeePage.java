package com.example.HR_AppJava.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class AddEmployeePage extends JFrame {
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

    public AddEmployeePage(EmployeeDemographics employee) {
        setTitle("HR App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 600));

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
        nameTextField = new JTextField();
        addressTextField = new JTextField();
        emailTextField = new JTextField();
        phoneNumTextField = new JTextField();
        currentTeamTextField = new JTextField();
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
                // TODO: Save data to EmployeeDemographics database

                dispose();
            }
        });

        // Create a new EmployeeJobHistory object that is connected to this employee
        addHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a Pop-up window that allows user to enter info for job history that
                // needs to be added to database then dispose pop-up

                // Creates a new Frame to be the base of the pop-up window
                JFrame addHistoryFrame = new JFrame();
                addHistoryFrame.setTitle("HR App");
                addHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addHistoryFrame.setPreferredSize(new Dimension(500, 600));

                JButton addHistoryButton = new JButton("Create");

                addHistoryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO: Save info from text fields to EmployeeJobHistory database

                        addHistoryFrame.dispose();
                    }
                });

                JPanel historyPanel = new JPanel();
                historyPanel.setLayout(new GridLayout(9, 2));
                historyPanel.add(companyNameLabel);
                historyPanel.add(companyNameTextField);
                historyPanel.add(supervisorLabel);
                historyPanel.add(supervisorTextField);
                historyPanel.add(lengthLabel);
                historyPanel.add(lengthSpinner);
                historyPanel.add(jobTitleLabel);
                historyPanel.add(jobTitleTextField);
                historyPanel.add(roleOnTeamLabel);
                historyPanel.add(roleOnTeamTextField);
                historyPanel.add(critSkillsLabel);
                historyPanel.add(critSkillsArea);
                historyPanel.add(softSkillsLabel);
                historyPanel.add(softSkillsArea);
                historyPanel.add(talentsLabel);
                historyPanel.add(talentsArea);
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

                evaluationButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO: Save info from text fields to EmployeeEvaluation database

                        evaluationFrame.dispose();
                    }
                });

                JPanel evaluationsPanel = new JPanel();
                evaluationsPanel.setLayout(new GridLayout(5, 2));
                evaluationsPanel.add(dateOfEvalLabel);
                evaluationsPanel.add(dateOfEvalSpinner);
                evaluationsPanel.add(mentalStateLabel);
                evaluationsPanel.add(mentalStateTextField);
                evaluationsPanel.add(evaluatingSupervisorLabel);
                evaluationsPanel.add(evaluatingSupervisorTextField);
                evaluationsPanel.add(notesLabel);
                evaluationsPanel.add(notesArea);
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
        jobHistoryPanel.add(new JLabel());
        jobHistoryPanel.add(addHistoryButton);

        // Evaluation Panel
        evaluationPanel = new JPanel();
        evaluationPanel.setLayout(new GridLayout(7, 2));
        evaluationPanel.setPreferredSize(new Dimension(1000, 600));
        evaluationPanel.add(employeeEvalLabel);
        evaluationPanel.add(new JLabel());
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