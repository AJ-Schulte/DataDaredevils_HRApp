package com.example.HR_AppJava.models;

public class EmployeeJobHistory {
    private String companyName;
    private String supervisor;
    private int lengthOnJob; // in months
    private String jobTitle;
    private String roleOnTeam;
    private String criticalSkills;
    private String softSkills;
    private String talents;
    private int employeeMemberID;

    // Constructors
    public EmployeeJobHistory() {
        companyName = "";
        supervisor = "";
        lengthOnJob = 0;
        jobTitle = "";
        roleOnTeam = "";
        criticalSkills = "";
        softSkills = "";
        talents = "";
    }

    public EmployeeJobHistory(String nameOfFormerCompany, String previousSupervisor, int lengthOfPreviousJob,
            String formerTitle, String role, int memberID) {
        this();
        companyName = nameOfFormerCompany;
        supervisor = previousSupervisor;
        lengthOnJob = lengthOfPreviousJob;
        jobTitle = formerTitle;
        roleOnTeam = role;
        employeeMemberID = memberID;
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

    public String getCriticalSkills() {
        return criticalSkills;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public String getTalents() {
        return talents;
    }

    public int getEmployeeMemberID() {
        return employeeMemberID;
    }

    // Setter methods
    public void setCriticalSkills(String criticalSkill) {
        criticalSkills = criticalSkill;
    }

    public void setSoftSkills(String softSkill) {
        softSkills = softSkill;
    }

    public void setTalents(String talent) {
        talents = talent;
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

}