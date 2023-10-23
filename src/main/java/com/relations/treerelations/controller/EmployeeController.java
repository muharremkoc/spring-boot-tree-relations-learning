package com.relations.treerelations.controller;

import com.relations.treerelations.domain.Employee;
import com.relations.treerelations.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/1/employee")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("")
    public List<Employee> getEmployees(){
        return employeeService.employeeList();
    }

    @PutMapping("/addSubOrganization")
    public void addEmployeeInSubOrganization(@RequestParam("employeeIds") List<Integer> employeeId,String subOrganizationName){
        employeeService.addEmployeeInSubOrganization(employeeId, subOrganizationName);
    }
}
