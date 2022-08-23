package com.employeerecord.employeerecordapp.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Award")
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long employeeId;
    private Integer yearVal;
    private Integer monthVal;

    public Award(){}


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }


    public Integer getYearVal() {
        return yearVal;
    }

    public void setYearVal(Integer yearVal) {
        this.yearVal = yearVal;
    }

    public Integer getMonthVal() {
        return monthVal;
    }

    public void setMonthVal(Integer monthVal) {
        this.monthVal = monthVal;
    }
}
