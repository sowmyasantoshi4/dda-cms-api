package com.cms.dda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.StaffMembers;

@Repository
public interface StaffMembersRepo extends JpaRepository<StaffMembers,Integer> {
	
	@Query("select sm from StaffMembers sm where sm.staffBranchId.branchId=:branchId")
	public List<StaffMembers> findByBranchId(@Param("branchId") Integer branchId);
	
	@Query("select sm from StaffMembers sm where sm.designationId.designationId=:desigId")
	public List<StaffMembers> findByDesigId(@Param("desigId") Integer desigId);
	
	@Query("select sm from StaffMembers sm where sm.staffBranchId.branchId=:branchId and sm.designationId.designationId=:desigId")
	public List<StaffMembers> findByBranchDesignationId(@Param("branchId") Integer branchId, @Param("desigId") Integer desigId);
	
	
	
}
