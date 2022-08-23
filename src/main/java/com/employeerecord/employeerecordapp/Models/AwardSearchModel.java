package com.employeerecord.employeerecordapp.Models;

import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Calendar;
import java.util.Date;

public class AwardSearchModel {
    @Min(value = 2000, message = "Year should not be less than 2000")
    @Max(value = 2050, message = "Year should not be greater than 2050")
    private int year;
    @Min(value = 1, message = "Month should not be less than 1")
    @Max(value = 12, message = "Month should not be greater than 12")
    private int month;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void Validate() throws CustomException {
        var calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        var currentYear =  calendar.get(Calendar.YEAR);
        if (currentYear < this.getYear()){
            throw new CustomException("Year should be equal or less than current year");
        }else if (currentYear == this.getYear()){
            var currentMonth = calendar.get(Calendar.MONTH) + 1;
            if (currentMonth < this.getMonth()){
                throw new CustomException("Month should be equal or less than current year");
            }
        }
    }
}
