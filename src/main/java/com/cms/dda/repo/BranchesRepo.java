package com.cms.dda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Branches;

@Repository
public interface BranchesRepo extends JpaRepository<Branches,Integer> {
	@Query(value="select b from Branches b where b.branchStateId.stateId=:stateId")
	List<Branches> findByBranchStateId(@Param("stateId") Integer stateId);
	
	@Query(value="select b from Branches b where b.branchStateId.stateId=:stateId and b.branchDistrictId.districtId=:districtId")
	public List<Branches> findByStateDistrictId(@Param("stateId") int stateId, @Param("districtId") int districtId);
	
}