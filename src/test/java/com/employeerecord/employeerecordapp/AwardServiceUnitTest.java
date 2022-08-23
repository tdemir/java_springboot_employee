package com.employeerecord.employeerecordapp;

import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;
import com.employeerecord.employeerecordapp.Models.AwardSearchModel;
import com.employeerecord.employeerecordapp.Services.AwardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardServiceUnitTest {
    @Autowired
    private AwardService service;

    @Test
    public void test1_whenApplicationStarts_ShouldNotHaveRecord(){
        //Arrange
        //Act
        var list = service.list();
        //Assert
        Assert.assertEquals(0,list.size());
    }

    @Test
    public void test2_GetEmployeeOfTheMonth_ShouldWork() throws CustomException {
        //Arrange
        var calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        var currentYear =  calendar.get(Calendar.YEAR);
        var currentMonth =  calendar.get(Calendar.MONTH) + 1;

        var model = new AwardSearchModel();
        model.setYear(currentYear);
        model.setMonth(currentMonth);

        //Act
        var result = service.GetEmployeeOfTheMonth(model);

        //Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(currentMonth, result.getMonth());
        Assert.assertEquals(currentYear, result.getYear());

    }

    @Test
    public void test3_GetEmployeeOfTheMonth_ShouldThrowException_WhenDateIsNotAppropriate(){
        //Arrange
        var calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        var currentYear =  calendar.get(Calendar.YEAR);
        var currentMonth =  calendar.get(Calendar.MONTH) + 1;

        var model = new AwardSearchModel();
        model.setYear(currentYear);
        model.setMonth(currentMonth);

        //Act
        var exception=Assert.assertThrows(CustomException.class, () -> service.GetEmployeeOfTheMonth(model));

        //Assert
        var expectedYearMessage = "Year should be equal or less than current year";
        var expectedMonthMessage = "Month should be equal or less than current year";
        Assert.assertTrue(exception.getMessage() == expectedYearMessage || exception.getMessage() == expectedMonthMessage);

    }
}
