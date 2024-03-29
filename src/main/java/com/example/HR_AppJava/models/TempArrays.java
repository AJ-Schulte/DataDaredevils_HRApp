package com.example.HR_AppJava.models;
import java.util.ArrayList;
public class TempArrays {
    //User array (Noah?)

    //EmployeeDemographics array (Ethan)
    static ArrayList<Object> employeeDemographicsArray = new ArrayList<>();
    public void addDemographic(Object e) {
        employeeDemographicsArray.add(e);
    }
    public void removeDemographic(Object e) {
        employeeDemographicsArray.remove(e);
    }
    public Object getDemographic(int i){
        return employeeDemographicsArray.get(i);
    }
    public void setDemographic(int i, Object e){
        employeeDemographicsArray.set(i,e);
    }

    //EmployeeJobHistory (AJ)

    //EmployeeEvaluation (Noah)
}
