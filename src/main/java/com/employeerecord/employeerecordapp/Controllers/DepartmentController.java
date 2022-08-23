package com.employeerecord.employeerecordapp.Controllers;

import com.employeerecord.employeerecordapp.Models.DepartmentModel;
import com.employeerecord.employeerecordapp.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<DepartmentModel> list(){
        return  service.list();
    }

    @GetMapping("/{id}")
    public DepartmentModel getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public  DepartmentModel Insert(@Valid @RequestBody DepartmentModel model) throws Exception {
        return service.insert(model);
    }

    @PutMapping
    public DepartmentModel Update(@Valid @RequestBody DepartmentModel model) throws Exception {
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public Boolean Delete(@PathVariable Long id){
        return service.delete(id);
    }
}
