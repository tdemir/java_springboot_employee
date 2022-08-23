package com.employeerecord.employeerecordapp.Models;

import com.employeerecord.employeerecordapp.Entities.Department;

import javax.validation.constraints.NotBlank;

public class DepartmentModel {
    private Long Id;
    @NotBlank(message = "Name is mandatory")
    private String Name;
    @NotBlank(message = "Office Address is mandatory")
    private String OfficeAddress;

    public DepartmentModel(){}

    public  DepartmentModel(Department input){
        this.setId(input.getId());
        this.setName(input.getName());
        this.setOfficeAddress(input.getOfficeAddress());
    }

    public Department GetDepartment(){
        var item = new Department();
        item.setId(this.getId());
        item.setName(this.getName());
        item.setOfficeAddress(this.getOfficeAddress());
        return item;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOfficeAddress() {
        return OfficeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        OfficeAddress = officeAddress;
    }
}
