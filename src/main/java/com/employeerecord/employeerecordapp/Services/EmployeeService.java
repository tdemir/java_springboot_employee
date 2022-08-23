package com.employeerecord.employeerecordapp.Services;

import com.employeerecord.employeerecordapp.Entities.Employee;
import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;
import com.employeerecord.employeerecordapp.Models.EmployeeModel;
import com.employeerecord.employeerecordapp.Models.EmployeeSearchModel;
import com.employeerecord.employeerecordapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository serviceRepository;

    public List<EmployeeModel> list(){
        var listData = serviceRepository.findAll();
        return GetList(listData);
    }

    public EmployeeModel getById(Long id){
        var data = serviceRepository.findById(id).orElse(null);
        if (data == null)
            return null;
        return new EmployeeModel(data);
    }

    public EmployeeModel insert(EmployeeModel model) {
        var item = model.GetEmployee();
        item.setId(0l);
        var response = serviceRepository.saveAndFlush(item);
        return new EmployeeModel(response);
    }

    public EmployeeModel update(EmployeeModel model) throws CustomException {
        var item = model.GetEmployee();
        if(item.getId() == null || item.getId() <= 0){
            throw new CustomException("Id shouldn't be empty");
        }
        var response = serviceRepository.saveAndFlush(item);
        return new EmployeeModel(response);
    }

    public Boolean delete(Long id){
        var item = this.getById(id);
        if (item != null){
            serviceRepository.deleteById(id);
        }
        return true;
    }

    public List<EmployeeModel> getByStartedDateAndSalary(EmployeeSearchModel model){
        var listData = serviceRepository.getByStartedDateAndSalary(model.getStartDate(), model.getSalary());
        return GetList(listData);
    }

    private List<EmployeeModel> GetList(List<Employee> listData){
        List<EmployeeModel> items = new ArrayList< >();
        if (listData == null)
            return items;

        listData.forEach(x -> {
            items.add(new EmployeeModel(x));
        });

        return items;
    }
}
