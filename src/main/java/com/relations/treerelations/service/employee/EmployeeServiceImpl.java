package com.relations.treerelations.service.employee;

import com.relations.treerelations.domain.Employee;
//import com.relations.treerelations.domain.SubOrganization;
import com.relations.treerelations.domain.Organization;
import com.relations.treerelations.repository.EmployeeRepository;
//import com.relations.treerelations.repository.SubOrganizationRepository;
import com.relations.treerelations.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    final EmployeeRepository employeeRepository;

    final OrganizationRepository subOrganizationRepository;



    public EmployeeServiceImpl(EmployeeRepository employeeRepository, OrganizationRepository subOrganizationRepository) {
        this.employeeRepository = employeeRepository;
        this.subOrganizationRepository = subOrganizationRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        return employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> employeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployeeInSubOrganization(List<Integer> employeeId, String subOrganizationName) {
        List<Employee> employee= employeeRepository.findAllByIdQuery(employeeId);
        Organization subOrganization = subOrganizationRepository.findByOrganizationName(subOrganizationName);
        employee.forEach(employee1 -> {
            employee1.setSubOrganization(subOrganization);
            subOrganization.getEmployees().add(employee1);
        });
        subOrganization.addEmployee(employee);

        employeeRepository.saveAll(employee);

        logger.info("Employees Added in SubOrganization");
    }
}
