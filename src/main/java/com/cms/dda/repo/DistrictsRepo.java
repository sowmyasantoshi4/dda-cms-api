package com.cms.dda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Districts;

@Repository
public interface DistrictsRepo extends JpaRepository<Districts,Integer>{

	@Query(value="select de from Districts de join de.states where de.states.stateId=:stateId")
	public List<Districts> findByStateId(@Param("stateId") int stateId);
	
	
}
