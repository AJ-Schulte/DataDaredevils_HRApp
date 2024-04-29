package com.example.HR_AppJava.models;

import java.util.ArrayList;

public class TempArrays {
    // User array (AJ)
    private static ArrayList<User> userArray = new ArrayList<>();

    public static void addUser(User user) {
        userArray.add(user);
    }

    public static void addUserAt(int index, User user) {
        userArray.add(index, user);
    }

    public static void removeUser(User user) {
        userArray.remove(user);
    }

    public static User getUser(int index) {
        return userArray.get(index);
    }

    public static void setUser(int index, User user) {
        userArray.set(index, user);
    }

    public static boolean doesUserExist(String username, char[] password) {
        for (User user : userArray) {
            if (user.getUsername().equals(username) && user.getPassword().equals(String.valueOf(password)))
                return true;
        }
        return false;
    }

    public static int searchForUser(String username, char[] password) {
        for (int i = 0; i < userArray.size(); i++) {
            if (userArray.get(i).getUsername().equals(username)
                    && userArray.get(i).getPassword().equals(String.valueOf(password)))
                return i;
        }
        return -1;
    }

    public static int searchForUser(User user) {
        for (int i = 0; i < userArray.size(); i++) {
            if (userArray.get(i).getUsername().equals(user.getUsername())
                    && userArray.get(i).getPassword().equals(String.valueOf(user.getPassword())))
                return i;
        }
        return -1;
    }

    // EmployeeDemographics array (Ethan)
    private static ArrayList<EmployeeDemographics> employeeDemographicsArray = new ArrayList<>();

    public static void addDemographic(EmployeeDemographics e) {
        employeeDemographicsArray.add(e);
    }

    public static void addDemographic(int i, EmployeeDemographics e) {
        i = IDGen.verifyIndex(i, employeeDemographicsArray.size());
        employeeDemographicsArray.add(i,e);
    }

    public static void removeDemographic(EmployeeDemographics e) {
        IDGen.markFreeIndex(e.getMemberID());
        employeeDemographicsArray.remove(e);
    }

    public static EmployeeDemographics getDemographic(int i) {
        return employeeDemographicsArray.get(i);
    }

    public static void setDemographic(int i, EmployeeDemographics e) {
        employeeDemographicsArray.set(i, e);
    }

    public static void setDemographic(int i, String name, String address, String phoneNumber, String email,
            String currentTeam) {
        employeeDemographicsArray.get(i).setName(name);
        employeeDemographicsArray.get(i).setAddress(address);
        employeeDemographicsArray.get(i).setPhoneNumber(phoneNumber);
        employeeDemographicsArray.get(i).setEmail(email);
        employeeDemographicsArray.get(i).setCurrentTeam(currentTeam);
    }

    public static int getDemographicSize() {
        return employeeDemographicsArray.size();
    }

    public static EmployeeDemographics searchDemographic(int memberID) throws Exception {
        EmployeeDemographics output = null; // output is initialized to null to prevent polluting the database with adummy object

        for (int i = 0; i < employeeDemographicsArray.size(); i++) {
            if (employeeDemographicsArray.get(i).getMemberID() == memberID) {
                output = employeeDemographicsArray.get(i); // output points to a specific index if it's found
                break; // faster
            }
        }

        if (output != null) {
            return output; // if output was changed, it's pointing to the matching true object and we can return it normally
        } else {
            throw new Exception("Employee could not be found."); // otherwise we don't have an object to return and it throws an exception instead
        }
    } // This architecture should work for any field of EmployeeDemographics, but it can't detect duplicates.

    // EmployeeJobHistory (AJ)
    private static ArrayList<EmployeeJobHistory> jobHistory = new ArrayList<>();

    public static void addToJobHistory(EmployeeJobHistory job) {
        jobHistory.add(job);
    }

    public static void addJobHistoryAt(int index, EmployeeJobHistory job) {
        jobHistory.add(index, job);
    }

    public static void setJobHistory(int index, EmployeeJobHistory job) {
        jobHistory.set(index, job);
    }

    public static void removeFromJobHistory(EmployeeJobHistory job) {
        jobHistory.remove(job);
    }

    public static EmployeeJobHistory getFromJobHistory(int index) {
        return jobHistory.get(index);
    }

    public static ArrayList<EmployeeJobHistory> getAllJobHistories(int memberID) {
        ArrayList<EmployeeJobHistory> indexes = new ArrayList<>();
        for (int i = 0; i < jobHistory.size(); i++) {
            if (jobHistory.get(i).getEmployeeMemberID() == memberID)
                indexes.add(jobHistory.get(i));
        }
        return indexes;
    }

    public static void removeAllJobHistories(int memberID) {
        for (int i = 0; i < jobHistory.size(); i++) {
            if (jobHistory.get(i).getEmployeeMemberID() == memberID)
                jobHistory.remove(jobHistory.get(i));
        }
    }

    // EmployeeEvaluation (Noah)
    private static ArrayList<EmployeeEvaluation> employeeEvaluation = new ArrayList<>();

    public static void addToEmployeeEvaluation(EmployeeEvaluation hires) {
        employeeEvaluation.add(hires);
    }

    public static void addToEmployeeEvaluationAt(int index, EmployeeEvaluation hires) {
        employeeEvaluation.add(index, hires);
    }

    public static void setEmployeeEvaluation(int index, EmployeeEvaluation hires) {
        employeeEvaluation.set(index, hires);
    }

    public static void removeFromEmployeeEvaluation(EmployeeEvaluation fired) {
        employeeEvaluation.remove(fired);
    }

    public static EmployeeEvaluation getEmployeeEvaluation(int index) {
        return employeeEvaluation.get(index);
    }

    public static ArrayList<EmployeeEvaluation> getAllEvaluations(int memberID) {
        ArrayList<EmployeeEvaluation> indexes = new ArrayList<>();
        for (int i = 0; i < employeeEvaluation.size(); i++) {
            if (employeeEvaluation.get(i).getEmployeeMemberID() == memberID)
                indexes.add(employeeEvaluation.get(i));
        }
        return indexes;
    }

    public static void removeAllEvaluations(int memberID) {
        for (int i = 0; i < employeeEvaluation.size(); i++) {
            if (employeeEvaluation.get(i).getEmployeeMemberID() == memberID)
                employeeEvaluation.remove(employeeEvaluation.get(i));
        }
    }
}