package com.cms.dda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Packages;

@Repository
public interface PackagesRepo extends JpaRepository<Packages,Integer> {
	
	@Query(value="select p from Packages p where p.referenceNo=:refNo")
	public Packages findByReferenceNo(@Param("refNo") Integer refNo);
	
	@Query(value="select p from Packages p  where p.referenceNo=:refNo")
	public List<Packages> getReport(@Param("refNo") Integer refNo);
	
}
