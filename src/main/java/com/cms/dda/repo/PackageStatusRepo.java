package com.cms.dda.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.PackagesStatus;

@Repository
public interface PackageStatusRepo extends JpaRepository<PackagesStatus,Integer> {
	
}
