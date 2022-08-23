package com.employeerecord.employeerecordapp.Models;

import com.employeerecord.employeerecordapp.Entities.Employee;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EmployeeModel {
    private Long Id;
    @Min(value = 1, message = "DepartmentId should be entered")
    private Long DepartmentId;
    @NotBlank(message = "FullName is mandatory")
    private String FullName;
    @NotNull(message = "StartDate cannot be null. Date format: yyyy-MM-dd")
    private Date StartDate;
    @Min(value = 0, message = "Salary should not be less than 0")
    private Double Salary;

    public EmployeeModel() {
    }

    public  EmployeeModel(Employee input){
        this.setId(input.getId());
        this.setDepartmentId(input.getDepartmentId());
        this.setFullName(input.getFullName());
        this.setStartDate(input.getStartDate());
        this.setSalary(input.getSalary());
    }

    public Employee GetEmployee(){
        var item = new Employee();
        item.setId(this.getId());
        item.setDepartmentId(this.getDepartmentId());
        item.setFullName(this.getFullName());
        item.setStartDate(this.getStartDate());
        item.setSalary(this.getSalary());
        return item;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Long departmentId) {
        DepartmentId = departmentId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }
}
