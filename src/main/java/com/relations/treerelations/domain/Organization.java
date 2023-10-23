package com.relations.treerelations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String organizationName;

  /*  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="organization")
    List<SubOrganization> subOrganizationList;
*/


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Organization> subOrganizationList;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="subOrganization")

    List<Employee> employees;
    public Organization() {
    }

    public Organization(int id, String organizationName) {
        this.id = id;
        this.organizationName = organizationName;
    }

    public Organization(int id, String organizationName, List<Organization> subOrganizationList) {
        this.id = id;
        this.organizationName = organizationName;
        this.subOrganizationList = subOrganizationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Organization> getSubOrganizationList() {
        return subOrganizationList;
    }

    public void setSubOrganizationList(List<Organization> subOrganizationList) {
        this.subOrganizationList = subOrganizationList;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(List<Employee> employees){

        employees.forEach(employee -> {
            employee.setSubOrganization(this);
        });

        this.employees=employees;

    }

    public void addSubOrganization(List<Organization> subOrganizations) {
        if (this.subOrganizationList == null) {
            this.subOrganizationList = new ArrayList<>();
        }

        this.subOrganizationList.addAll(subOrganizations);
    }

}
