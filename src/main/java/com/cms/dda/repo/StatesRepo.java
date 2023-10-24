package com.cms.dda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.States;

@Repository
public interface StatesRepo extends JpaRepository<States,Integer> {
	
	public List<States> findAllByOrderByStateId();

}
