package com.relations.treerelations.repository;

import com.relations.treerelations.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    @Query("from Employee j where j.id in (select distinct i.id from Employee i " +
            "where ((i.id IN (:employeeIds))))"
    )
    List<Employee> findAllByIdQuery(List<Integer> employeeIds);


}
