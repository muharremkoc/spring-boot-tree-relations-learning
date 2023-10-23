package com.relations.treerelations.service.employee;


import com.relations.treerelations.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> employeeList();

    void addEmployeeInSubOrganization(List<Integer> employeeId,String subOrganizationName);

}
