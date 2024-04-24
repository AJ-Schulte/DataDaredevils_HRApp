/* 
 * This class holds demographic information on an employee. 
 * It currently requires all fields to be filled on construction, and autosaves to the "database".
 * If you need a dummy instance, try initializing to null before rewriting this. (see implementation in TempArrays)
*/
package com.example.HR_AppJava.models;

public class EmployeeDemographics {
    // Fields
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int memberID;
    private String currentTeam;

    // Constructors
    public EmployeeDemographics(String name, String address, String phoneNumber, String email, String currentTeam) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        memberID = IDGen.getID();
        this.currentTeam = currentTeam;
        save(); // The autosave is convienent but I can see how it might cause problems. Remove it if needed.
    }

    public EmployeeDemographics(int memberID, String name, String address, String phoneNumber, String email, String currentTeam) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.memberID = memberID;
        this.currentTeam = currentTeam;
        save(); // The autosave is convienent but I can see how it might cause problems. Remove it if needed.
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    // Database Interactions
    public void save() { // write to database
        TempArrays.addDemographic(this.memberID, this);
    }

    public void delete() { // remove from database
        TempArrays.removeDemographic(this);
    }

    // Other
    public String toString() { // mainly for testing
        return name + ", " + address + ", " + phoneNumber + ", " + email + ", " + memberID + ", " + currentTeam;
    }
}