package com.cms.dda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dda.dto.PackagesDto;
import com.cms.dda.model.GlobalReport;
import com.cms.dda.service.GlobalReportService;
import com.cms.dda.service.PackagesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/packages")
public class PackagesController {
	
	@Autowired
	PackagesService pkSer;
	
//	@Autowired
//	GlobalReportService grSer;
	
	@GetMapping("/all")
	public List<PackagesDto> findAll() {
		return pkSer.findAll();
	}
	
	@GetMapping("/byRefNo/{refNo}")
	public PackagesDto findByRefNo(@PathVariable Integer refNo) {
		return pkSer.findByReferenceNo(refNo);
	}
	
//	@GetMapping("/report")
//	public List<PackagesDto> getReport(@RequestBody GlobalReport gr) {
//		return grSer.getReport(gr);
//	}
	
}
