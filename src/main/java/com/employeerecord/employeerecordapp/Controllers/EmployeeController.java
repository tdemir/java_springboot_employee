package com.employeerecord.employeerecordapp.Controllers;

import com.employeerecord.employeerecordapp.Models.EmployeeModel;
import com.employeerecord.employeerecordapp.Models.EmployeeSearchModel;
import com.employeerecord.employeerecordapp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeModel> list(){
        return  service.list();
    }

    @GetMapping("/{id}")
    public EmployeeModel getById(@PathVariable Long id){
        return  service.getById(id);
    }

    @PostMapping
    public EmployeeModel Insert(@Valid @RequestBody EmployeeModel model) throws Exception {
        return service.insert(model);
    }

    @PutMapping
    public EmployeeModel Update(@Valid @RequestBody EmployeeModel model) throws Exception {
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public Boolean Delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("/getByStartedDateAndSalary")
    public List<EmployeeModel> getByStartedDateAndSalary(@Valid EmployeeSearchModel model){
        return service.getByStartedDateAndSalary(model);
    }
}
