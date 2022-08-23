package com.employeerecord.employeerecordapp.Services;

import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;
import com.employeerecord.employeerecordapp.Models.DepartmentModel;
import com.employeerecord.employeerecordapp.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository serviceRepository;

    public List<DepartmentModel> list(){
        List<DepartmentModel> items = new ArrayList< >();
        var listData = serviceRepository.findAll();
        listData.forEach(x -> {
            items.add(new DepartmentModel(x));
        });

        return items;
    }

    public DepartmentModel getById(Long id){
        var data = serviceRepository.findById(id).orElse(null);
        if (data == null)
            return null;
        return new DepartmentModel(data);
    }

    public DepartmentModel insert(DepartmentModel model) {
        var item = model.GetDepartment();
        item.setId(0l);
        var response = serviceRepository.saveAndFlush(item);
        return new DepartmentModel(response);
    }

    public DepartmentModel update(DepartmentModel model) throws CustomException {
        var item = model.GetDepartment();
        if(item.getId() == null || item.getId() <= 0){
            throw new CustomException("Id shouldn't be empty");
        }
        var response = serviceRepository.saveAndFlush(item);
        return new DepartmentModel(response);
    }

    public Boolean delete(Long id){
        var item = this.getById(id);
        if (item != null){
            serviceRepository.deleteById(id);
        }
        return true;
    }
}
