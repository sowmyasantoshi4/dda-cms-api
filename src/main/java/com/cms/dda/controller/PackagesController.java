package com.cms.dda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dda.dto.PackagesDto;
import com.cms.dda.dto.UpdatePackagesStatusDto;
import com.cms.dda.model.GlobalReport;
import com.cms.dda.service.PackagesService;

@RestController
@RequestMapping("/packages")
public class PackagesController {
	
	@Autowired
	PackagesService pkSer;
	
	@GetMapping("/all")
	public List<PackagesDto> findAll() {
		return pkSer.findAll();
	}
	
	@GetMapping("/byRefNo/{refNo}")
	public PackagesDto findByRefNo(@PathVariable Integer refNo) {
		return pkSer.findByReferenceNo(refNo);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody PackagesDto pk){
		int refNo = pkSer.save(pk);
		return new ResponseEntity<>(refNo, HttpStatus.CREATED);
	}
	
	@PostMapping("/updateStatus")
	public ResponseEntity<?> updateStatus(@RequestBody UpdatePackagesStatusDto upks){
		int refNo = pkSer.updateStatus(upks);
		return new ResponseEntity<>(refNo, HttpStatus.CREATED);
	}
	
	@PostMapping("/report")
	public List<PackagesDto> getGlobalReport(@RequestBody GlobalReport gr) {
		return pkSer.getGlobalReport(gr);
	}
	
}
