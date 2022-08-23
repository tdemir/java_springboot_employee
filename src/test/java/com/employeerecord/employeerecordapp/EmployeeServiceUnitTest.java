package com.employeerecord.employeerecordapp;

import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;
import com.employeerecord.employeerecordapp.Models.DepartmentModel;
import com.employeerecord.employeerecordapp.Models.EmployeeModel;
import com.employeerecord.employeerecordapp.Models.EmployeeSearchModel;
import com.employeerecord.employeerecordapp.Services.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceUnitTest {
    @Autowired
    private EmployeeService service;

    @Test
    public void test1_whenApplicationStarts_ShouldHaveRecord(){
        //Arrange
        //Act
        var list = service.list();
        //Assert
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void test2_getById_ShouldBeExist(){
        //Arrange
        long id = 1l;
        //Act
        var data = service.getById(id);
        //Assert
        Assert.assertNotNull(data);
    }

    @Test
    public void test3_getById_ShouldReturnNull(){
        //Arrange
        long id = 0l;
        //Act
        var data = service.getById(id);
        //Assert
        Assert.assertNull(data);
    }

    @Test
    public void test4_getByStartedDateAndSalary_ShouldWork(){
        //Arrange
        var model = new EmployeeSearchModel();
        model.setSalary(1d);
        model.setStartDate(Date.valueOf("2022-06-15"));
        //Act
        var data = service.getByStartedDateAndSalary(model);
        //Assert
        Assert.assertNotNull(data);
        Assert.assertEquals(1, data.size());
    }

    @Test
    public void test5_insert_ShouldWork()  {
        //Arrange
        var item = new EmployeeModel();
        item.setSalary(5d);
        item.setStartDate(Date.valueOf("2020-01-01"));
        item.setDepartmentId(1l);
        item.setFullName("test");

        //Act
        var result = service.insert(item);

        //Assert
        Assert.assertEquals(item.getFullName(), result.getFullName());
        Assert.assertEquals(true, result.getId() > 0);
    }

    @Test
    public void test6_update_ShouldWork() throws CustomException {
        //Arrange
        var item = new EmployeeModel();
        item.setId(1l);
        item.setSalary(5d);
        item.setStartDate(Date.valueOf("2020-01-01"));
        item.setDepartmentId(1l);
        item.setFullName("test");

        //Act
        var result = service.update(item);

        //Assert
        Assert.assertEquals(item.getFullName(), result.getFullName());
        Assert.assertEquals(item.getId(), result.getId());
    }

    @Test
    public void test7_update_ShouldThrow_Exception_When_Id_Null() throws CustomException {
        //Arrange
        var item = new EmployeeModel();
        item.setId(null);
        item.setSalary(5d);
        item.setStartDate(Date.valueOf("2020-01-01"));
        item.setDepartmentId(1l);
        item.setFullName("test");

        //Act
        var exception=Assert.assertThrows(CustomException.class, () -> service.update(item));

        //Assert
        Assert.assertEquals("Id shouldn't be empty",exception.getMessage());
    }

    @Test
    public void test8_delete_ShouldWork(){
        //Arrange
        long id = 3l;

        //Act
        var result = service.delete(id);

        //Assert
        Assert.assertEquals(true, result);
    }
}
