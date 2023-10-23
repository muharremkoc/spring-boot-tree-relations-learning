package com.relations.treerelations.controller;

import com.relations.treerelations.domain.Organization;
import com.relations.treerelations.service.organization.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/1/organizaton")
public class OrganizationController {

    final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("")
    public Organization organization(@RequestBody Organization organization){
        return organizationService.create(organization);
    }

    @PostMapping("/withName")
    public Organization organizationWithName(@RequestBody Organization organization,@RequestParam String organizationName){
        return organizationService.createWithOrganizationName(organization,organizationName);
    }

    @GetMapping("")
    public List<Organization> getOrganizations(){
        return organizationService.getOrganizations();
    }


}
