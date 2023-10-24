package com.cms.dda.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Packages;

@Repository
public interface PackagesRepo extends JpaRepository<Packages,Integer> {
	
}
