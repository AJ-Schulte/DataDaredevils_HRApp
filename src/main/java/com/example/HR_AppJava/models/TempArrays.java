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

    public static Object getUser(int index) {
        return userArray.get(index);
    }

    public static boolean doesUserExist(String username, char[] password) {
        for (User user : userArray) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    // EmployeeDemographics array (Ethan)
    private static ArrayList<EmployeeDemographics> employeeDemographicsArray = new ArrayList<>();

    public static void addDemographic(EmployeeDemographics e) {
        employeeDemographicsArray.add(e);
    }

    public static void removeDemographic(EmployeeDemographics e) {
        employeeDemographicsArray.remove(e);
    }

    public static EmployeeDemographics getDemographic(int i) {
        return employeeDemographicsArray.get(i);
    }

    public static void setDemographic(int i, EmployeeDemographics e) {
        employeeDemographicsArray.set(i, e);
    }

    public static EmployeeDemographics searchDemographic(int memberID) throws Exception {
        EmployeeDemographics output = null; // output is initialized to null to prevent polluting the database with a
                                            // dummy object

        for (int i = 0; i < employeeDemographicsArray.size(); i++) {
            if (employeeDemographicsArray.get(i).getMemberID() == memberID) {
                output = employeeDemographicsArray.get(i); // output points to a specific index if it's found
            }
        }

        if (output != null) {
            return output; // if output was changed, it's pointing to the matching true object and we can
                           // return it normally
        } else {
            throw new Exception("Employee could not be found."); // otherwise we don't have an object to return and it
                                                                 // throws an exception instead
        }
    }

    // EmployeeJobHistory (AJ)
    private static ArrayList<EmployeeJobHistory> jobHistory = new ArrayList<>();

    public static void addToJobHistory(EmployeeJobHistory job) {
        jobHistory.add(job);
    }

    public static void addJobHistoryAt(int index, EmployeeJobHistory job) {
        jobHistory.add(index, job);
    }

    public static void removeFromJobHistory(EmployeeJobHistory job) {
        jobHistory.remove(job);
    }

    public static Object getFromJobHistory(int index) {
        return jobHistory.get(index);
    }

    // EmployeeEvaluation (Noah)
    private static ArrayList<EmployeeEvaluation> employeeEvaluation = new ArrayList<>();

    public static void addToEmployeeEvaluation(EmployeeEvaluation hires) {
        employeeEvaluation.add(hires);
    }

    public static void addToEmployeeEvaluationAt(int index, EmployeeEvaluation hires) {

        employeeEvaluation.add(index, hires);
    }

    public static void removeFromEmployeeEvaluation(EmployeeEvaluation fired) {
        employeeEvaluation.remove(fired);
    }

    public static Object getEmployeeEvaluation(int index) {
        return employeeEvaluation.get(index);
    }
}
