package com.cms.dda.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.Designation;

@Repository
public interface DesignationRepo extends JpaRepository<Designation,Integer> {

}
