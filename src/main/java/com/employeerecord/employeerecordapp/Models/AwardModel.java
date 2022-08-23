package com.employeerecord.employeerecordapp.Models;

import com.employeerecord.employeerecordapp.Entities.Award;
import com.employeerecord.employeerecordapp.Entities.Employee;

public class AwardModel {
    private Long Id;
    private Long EmployeeId;
    private int Year;
    private int Month;
    private String FullName;

    public AwardModel(){}

    public AwardModel(Award award, Employee employee){
        this.setId(award.getId());
        this.setEmployeeId(award.getEmployeeId());
        this.setYear(award.getYearVal());
        this.setMonth(award.getMonthVal());
        this.setFullName(employee.getFullName());
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
