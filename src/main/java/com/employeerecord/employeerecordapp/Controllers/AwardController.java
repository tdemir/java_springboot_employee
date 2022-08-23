package com.employeerecord.employeerecordapp.Controllers;

import com.employeerecord.employeerecordapp.Entities.Award;
import com.employeerecord.employeerecordapp.Models.*;
import com.employeerecord.employeerecordapp.Services.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/awards")
public class AwardController {
    @Autowired
    private AwardService service;

    @GetMapping
    public List<Award> list(){
        return  service.list();
    }

    @GetMapping("/getEmployeeOfTheMonth")
    public AwardModel getByStartedDateAndSalary(@Valid AwardSearchModel model) throws Exception {
        return service.GetEmployeeOfTheMonth(model);
    }
}
