package com.example.HR_AppJava.models;

public class EmployeeJobHistory {
    private String companyName;
    private String supervisor;
    private int lengthOnJob; // in months
    private String jobTitle;
    private String roleOnTeam;
    private String[] criticalSkills;
    private int criticalSkillsSize;
    private String[] softSkills;
    private int softSkillsSize;
    private String[] talents;
    private int talentsSize;

    // Constructors
    public EmployeeJobHistory() {
        companyName = "";
        supervisor = "";
        lengthOnJob = 0;
        jobTitle = "";
        roleOnTeam = "";
        criticalSkills = new String[10];
        softSkills = new String[10];
        talents = new String[10];
    }

    public EmployeeJobHistory(String nameOfFormerCompany, String previousSupervisor, int lengthOfPreviousJob,
            String formerTitle, String role) {
        this();
        companyName = nameOfFormerCompany;
        supervisor = previousSupervisor;
        lengthOnJob = lengthOfPreviousJob;
        jobTitle = formerTitle;
        roleOnTeam = role;
    }

    // Getter methods
    public String getCompanyName() {
        return companyName;
    }

    public int getLengthOnJob() {
        return lengthOnJob;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getRoleOnTeam() {
        return roleOnTeam;
    }

    public String[] getCriticalSkills() {
        return criticalSkills;
    }

    public String[] getSoftSkills() {
        return softSkills;
    }

    public String[] getTalents() {
        return talents;
    }

    // Setter methods
    public void addToCriticalSkill(String criticalSkill) {
        if (criticalSkillsSize == criticalSkills.length)
            criticalSkills = EmployeeJobHistory.expandCapacity(criticalSkills);
        criticalSkills[criticalSkillsSize] = criticalSkill;
        criticalSkillsSize++;
    }

    public void addToSoftSkills(String softSkill) {
        if (softSkillsSize == softSkills.length)
            softSkills = EmployeeJobHistory.expandCapacity(softSkills);
        softSkills[softSkillsSize] = softSkill;
        softSkillsSize++;
    }

    public void addToTalents(String talent) {
        if (talentsSize == talents.length)
            talents = EmployeeJobHistory.expandCapacity(talents);
        talents[talentsSize] = talent;
        talentsSize++;
    }

    public void setCompanyName(String nameOfCompany) {
        companyName = nameOfCompany;
    }

    public void setSupervisor(String previousSupervisor) {
        supervisor = previousSupervisor;
    }

    public void setLengthOnJob(int lengthOfPreviousJob) {
        lengthOnJob = lengthOfPreviousJob;
    }

    public void setJobTitle(String previousJobTitle) {
        jobTitle = previousJobTitle;
    }

    public void setRoleOnTeam(String role) {
        roleOnTeam = role;
    }

    // expand capacity method to increase array sizes
    private static String[] expandCapacity(String[] arr) {
        // create new bigger array
        String[] temp = new String[arr.length * 2];

        // copy old values into new array
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];

        // update property to point to new array
        arr = temp;
        return arr;
    }
}