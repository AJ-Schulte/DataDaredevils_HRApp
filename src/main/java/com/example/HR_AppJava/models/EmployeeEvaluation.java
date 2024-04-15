package com.example.HR_AppJava.models;

public class EmployeeEvaluation {

    private Integer dateOfEval;
    private String mentalState;
    private String employeeNotes;
    private String evaluatingSupervisor;

    public EmployeeEvaluation(String evaluatingSupervisor, Integer dateOfEval, String mentalState,
            String employeeNotes) {
        this.evaluatingSupervisor = evaluatingSupervisor;
        this.dateOfEval = dateOfEval;
        this.mentalState = mentalState;
        this.employeeNotes = employeeNotes;
    }

    public String getEvaluatingSupervisor() {
        return evaluatingSupervisor;
    }

    public Integer getDateofEval() {
        return dateOfEval;
    }

    public String getMentalstate() {
        return mentalState;
    }

    public String getEmployeenotes() {
        return employeeNotes;
    }

    // Setters
    public void setEvaluatingSupervisor(String evaluatingSupervisor) {
        this.evaluatingSupervisor = evaluatingSupervisor;
    }

    public void setDateofEval(Integer dateOfEval) {
        this.dateOfEval = dateOfEval;
    }

    public void setMentalstate(String mentalState) {
        this.mentalState = mentalState;
    }

    public void setEmpoyeenotes(String employeeNotes) {
        this.employeeNotes = employeeNotes;
    }

}
