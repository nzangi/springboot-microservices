package com.nzangi.departmentservice.controller;

import com.nzangi.departmentservice.client.EmployeeClient;
import com.nzangi.departmentservice.model.Department;
import com.nzangi.departmentservice.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(DepartmentController.class);
//    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private DepartmentRepository departmentRepository;

    //DI
//    public  DepartmentController(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("Department add: {}",department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAllDepartments(){
        LOGGER.info("Find all Departments");
        return departmentRepository.findAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public Department findDepartmentById(@PathVariable Long departmentId){
        LOGGER.info("Find Department: departmentId={}",departmentId);
        return departmentRepository.findDepartmentById(departmentId);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllDepartmentsWithEmployees(){
        LOGGER.info("Find all Departments With Employees");
        List<Department> departments = departmentRepository.findAllDepartments();
        departments.forEach(
                department -> department.setEmployees(employeeClient.findEmployeeByDepartment(department.getDepartmentId()))
        );
        return departments;
    }





}
