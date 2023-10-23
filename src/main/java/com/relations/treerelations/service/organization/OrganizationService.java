package com.relations.treerelations.service.organization;

import com.relations.treerelations.domain.Organization;

import java.util.List;

public interface OrganizationService {

    Organization create(Organization organization);

    Organization createWithOrganizationName(Organization subOrganization,String organizationName);


    List<Organization> getOrganizations();

}
