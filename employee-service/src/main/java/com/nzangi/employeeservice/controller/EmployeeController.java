package com.nzangi.employeeservice.controller;

import com.nzangi.employeeservice.model.Employee;
import com.nzangi.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("Employee Add: {}",employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        LOGGER.info("Get all employees: ");
        return employeeRepository.findAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable Long employeeId){
        LOGGER.info("Find Employee by employeeId= {}",employeeId);
        return employeeRepository.findEmployeeById(employeeId);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employee find by: departmentId={}",departmentId);
        return employeeRepository.findEmployeeByDepartment(departmentId);
    }


}
