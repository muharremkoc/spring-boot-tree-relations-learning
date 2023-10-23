package com.relations.treerelations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Organization subOrganization;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, Organization subOrganization) {
        this.id = id;
        this.name = name;
        this.subOrganization = subOrganization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getSubOrganization() {
        return subOrganization;
    }

    public void setSubOrganization(Organization subOrganization) {
        this.subOrganization = subOrganization;
    }


}
