package com.cms.dda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.cms.dda.model.GlobalReport;
import com.cms.dda.model.States;

//@Repository
public interface GlobalReportRepo {//extends JpaRepository<GlobalReport,Integer>, QueryByExampleExecutor<GlobalReport> {
	
	public List<States> findAllByOrderByStateId();

}
