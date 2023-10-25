package com.cms.dda.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.dda.dto.PackagesDto;
import com.cms.dda.model.GlobalReport;
import com.cms.dda.model.Packages;


//@Service
public class GlobalReportService {
	private static final Logger log = LoggerFactory.getLogger(StatusService.class);
	
	public List<PackagesDto> getReport(GlobalReport gr) {
		log.info("In GlobalReportService :: getReport");
		List<PackagesDto> li = null;
		
		GlobalReport rep = new GlobalReport();
		rep.setFromBranchId(gr.getFromBranchId());
		rep.setToBranchId(gr.getToBranchId());
		rep.setFromDate(gr.getFromDate());
		rep.setToDate(gr.getToDate());
		rep.setStatusId(gr.getStatusId());
		rep.setReferenceNo(gr.getReferenceNo());
		
		Packages p = new Packages();
		//p.setSendingBranchId(gr.getFromBranchId());
		
		//Example<GlobalReport> example = Example.of(rep);   
		
		return li;
	}
	
}
