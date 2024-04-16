package com.example.HR_AppJava.models;

import java.util.Date;

public class EmployeeEvaluation {

    private Date dateOfEval;
    private String mentalState;
    private String employeeNotes;
    private String evaluatingSupervisor;
    private int memberID;

    public EmployeeEvaluation(String evaluatingSupervisor, Date dateOfEval, String mentalState,
            String employeeNotes, int memberID) {
        this.evaluatingSupervisor = evaluatingSupervisor;
        this.dateOfEval = dateOfEval;
        this.mentalState = mentalState;
        this.employeeNotes = employeeNotes;
        this.memberID = memberID;
    }

    public String getEvaluatingSupervisor() {
        return evaluatingSupervisor;
    }

    public Date getDateofEval() {
        return dateOfEval;
    }

    public String getMentalstate() {
        return mentalState;
    }

    public String getEmployeenotes() {
        return employeeNotes;
    }

    public int getEmployeeMemberID() {
        return memberID;
    }

    // Setters
    public void setEvaluatingSupervisor(String evaluatingSupervisor) {
        this.evaluatingSupervisor = evaluatingSupervisor;
    }

    public void setDateofEval(Date dateOfEval) {
        this.dateOfEval = dateOfEval;
    }

    public void setMentalstate(String mentalState) {
        this.mentalState = mentalState;
    }

    public void setEmpoyeenotes(String employeeNotes) {
        this.employeeNotes = employeeNotes;
    }

}
