package com.relations.treerelations.repository;

import com.relations.treerelations.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {

    Organization findByOrganizationName(String organizationName);
}
