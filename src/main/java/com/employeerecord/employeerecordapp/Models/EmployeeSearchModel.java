package com.employeerecord.employeerecordapp.Models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public final class EmployeeSearchModel {
    @NotNull(message = "StartDate cannot be null. Date format: yyyy-MM-dd")
    private Date startDate;
    @Min(value = 0, message = "Salary should not be less than 0")
    private Double salary;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
