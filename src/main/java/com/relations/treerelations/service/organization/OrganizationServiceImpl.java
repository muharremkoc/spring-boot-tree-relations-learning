package com.relations.treerelations.service.organization;

import com.relations.treerelations.domain.Organization;
import com.relations.treerelations.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization create(Organization organization) {
        Organization newOrganization = new Organization();
        newOrganization.setOrganizationName(organization.getOrganizationName());

        return organizationRepository.save(newOrganization);
    }

    @Override
    public Organization createWithOrganizationName(Organization subOrganization, String organizationName) {
        List<Organization> newSubOrganization = new ArrayList<>();
        subOrganization.setOrganizationName(subOrganization.getOrganizationName());
        Organization organization = organizationRepository.findByOrganizationName(organizationName);

        organizationRepository.save(subOrganization);
        newSubOrganization.add(subOrganization);
        organization.addSubOrganization(newSubOrganization);
        organizationRepository.save(organization);


        return organization;
    }

    @Override
    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }
}
