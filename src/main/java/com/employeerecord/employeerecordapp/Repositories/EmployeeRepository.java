package com.employeerecord.employeerecordapp.Repositories;

import com.employeerecord.employeerecordapp.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("Select e from Employee e where e.StartDate > :startDate and e.Salary > :salary")
    List<Employee> getByStartedDateAndSalary(@Param("startDate") Date startDate, @Param("salary") Double salary);

}
