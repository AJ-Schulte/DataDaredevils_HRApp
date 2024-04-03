package com.example.HR_AppJava.models;

import java.util.ArrayList;

public class TempArrays {
    // User array (AJ)
    private ArrayList<Object> userArray = new ArrayList<>();

    public void addUser(User user) {
        userArray.add(user);
    }

    public void addUserAt(int index, User user) {
        userArray.add(index, user);
    }

    public void removeUser(User user) {
        userArray.remove(user);
    }

    public Object getUser(int index) {
        return userArray.get(index);
    }

    // EmployeeDemographics array (Ethan)

    // EmployeeJobHistory (AJ)
    private ArrayList<Object> jobHistory = new ArrayList<>();

    public void addToJobHistory(EmployeeJobHistory job) {
        jobHistory.add(job);
    }

    public void addJobHistoryAt(int index, EmployeeJobHistory job) {
        jobHistory.add(index, job);
    }

    public void removeFromJobHistory(EmployeeJobHistory job) {
        jobHistory.remove(job);
    }

    public Object getFromJobHistory(int index) {
        return jobHistory.get(index);
    }
    // EmployeeEvaluation (Noah)
}
