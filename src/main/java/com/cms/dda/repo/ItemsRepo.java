package com.cms.dda.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Items;

@Repository
public interface ItemsRepo extends JpaRepository<Items,Integer> {
	
}
