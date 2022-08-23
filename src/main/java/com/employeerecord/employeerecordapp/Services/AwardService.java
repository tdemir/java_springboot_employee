package com.employeerecord.employeerecordapp.Services;


import com.employeerecord.employeerecordapp.Entities.Award;
import com.employeerecord.employeerecordapp.Helpers.Exceptions.CustomException;
import com.employeerecord.employeerecordapp.Models.AwardModel;
import com.employeerecord.employeerecordapp.Models.AwardSearchModel;
import com.employeerecord.employeerecordapp.Repositories.AwardRepository;
import com.employeerecord.employeerecordapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AwardService {
    @Autowired
    private AwardRepository awardRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Award> list(){
        return awardRepository.findAll();
    }

    public AwardModel GetEmployeeOfTheMonth(AwardSearchModel model) throws CustomException {
       model.Validate();

      var awards=  awardRepository.findByYearAndMonth(model.getYear(), model.getMonth());
      if (awards.isEmpty()){

          var employeeCount =  employeeRepository.count();
          var randomEmployeeIndex = ThreadLocalRandom.current().nextLong(0, employeeCount);
            var employees=employeeRepository.findAll(PageRequest.of(Integer.parseInt(randomEmployeeIndex+""), 1));

            if (employees.isEmpty()){
                throw new CustomException("Employee not found");
            }
            var employee = employees.stream().findFirst().get();

            var awardItem = new Award();
            awardItem.setEmployeeId(employee.getId());
            awardItem.setYearVal(model.getYear());
            awardItem.setMonthVal(model.getMonth());

          var awardItemResponse =  awardRepository.saveAndFlush(awardItem);
          return new AwardModel(awardItemResponse, employee);
      }
      var awardData = awards.stream().findFirst().get();
      var employeeData = employeeRepository.findById(awardData.getEmployeeId()).get();
      return new AwardModel(awardData, employeeData);
    }
}
