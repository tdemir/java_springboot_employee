package com.employeerecord.employeerecordapp;

import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;
import com.employeerecord.employeerecordapp.Models.DepartmentModel;
import com.employeerecord.employeerecordapp.Services.DepartmentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceUnitTest {
    @Autowired
    private DepartmentService service;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
        //Arrange
        //Act
        var list = service.list();
        //Assert
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void getDepartmentById_ShouldWork(){
        //Arrange
        long id = Long.valueOf(1);
        //Act
        var data = service.getById(id);
        //Assert
        Assert.assertNotNull(data);
    }

    @Test
    public void getDepartmentByIdShouldReturnNull_WhenNotExist(){
        //Arrange
        long id = Long.valueOf(0);
        //Act
        var data = service.getById(id);
        //Assert
        Assert.assertNull(data);
    }

    @Test
    public void insertDepartment_ShouldWork(){
        //Arrange
        var item = new DepartmentModel();
        item.setName("test");
        item.setOfficeAddress("office");

        //Act
        var result = service.insert(item);

        //Assert
        Assert.assertEquals(item.getName(), result.getName());
        Assert.assertEquals(true, result.getId() > 0);
    }

    @Test
    public void updateDepartment_ShouldWork() throws CustomException {
        //Arrange
        var item = new DepartmentModel();
        item.setId(1l);
        item.setName("test");
        item.setOfficeAddress("office");

        //Act
        var result = service.update(item);

        //Assert
        Assert.assertEquals(item.getName(), result.getName());
        Assert.assertEquals(item.getId(), result.getId());
    }

    @Test
    public void updateDepartment_ShouldThrow_Exception_When_Id_Null() throws CustomException {
        //Arrange
        var item = new DepartmentModel();
        item.setId(null);
        item.setName("test");
        item.setOfficeAddress("office");

        //Act
        var exception=Assert.assertThrows(CustomException.class, () -> service.update(item));

        //Assert
        Assert.assertEquals("Id shouldn't be empty",exception.getMessage());
    }

    @Test
    public void deleteDepartment_ShouldWork(){
        //Arrange
        long id = 2l;

        //Act
        var result = service.delete(id);

        //Assert
        Assert.assertEquals(true, result);
    }
}
