package com.cms.dda.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status,Integer> {
	
}
