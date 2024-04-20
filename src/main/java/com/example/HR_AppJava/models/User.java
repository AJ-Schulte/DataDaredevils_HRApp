package com.example.HR_AppJava.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;
    private String password;
    private String company;
    private boolean isSupervisor;

    // Constructors, getters, and setters

    // Constructor without id (for creating instances)
    public User(String username, String email, String password, String company, boolean isSupervisor) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.company = company;
        this.isSupervisor = isSupervisor;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    //Manager Functions - Ethan
    public void createReview(User manager, User employee, String mentalStateIn, String employeeNotesIn){
        if(!manager.isSupervisor) return;
        if(!manager.company.equals(employee.company)) return;
        String mentalState = mentalStateIn;
        String employeeNotes = employeeNotesIn;
        Calendar calendar = Calendar.getInstance();
        Date reviewDate = calendar.getTime();
        EmployeeEvaluation review = new EmployeeEvaluation(manager.username, reviewDate , mentalState, employeeNotes, employee.getId());
        System.out.println("Created review");
        TempArrays.addToEmployeeEvaluation(review);
        System.out.println("Saved review");
    }
}