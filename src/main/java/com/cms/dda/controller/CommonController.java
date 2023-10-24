package com.cms.dda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dda.dto.DesignationDto;
import com.cms.dda.dto.DistrictsDto;
import com.cms.dda.dto.StatesDto;
import com.cms.dda.dto.StatusDto;
import com.cms.dda.service.DesignationService;
import com.cms.dda.service.DistrictsService;
import com.cms.dda.service.StatesService;
import com.cms.dda.service.StatusService;

@RestController
public class CommonController {
	
	
	@Autowired
	DistrictsService distSer;
	
	@Autowired
	StatesService statesSer;
	
	@Autowired
	StatusService statusSer;
	
	@Autowired
	DesignationService desigSer;
	
	/*
	 * Gets All States
	 */
	@GetMapping("/states")
	public List<StatesDto> getStates() {
		return statesSer.findAll();
	}
	
	/*
	 * Gets All Status
	 */
	@GetMapping("/status")
	public List<StatusDto> getStatus() {
		return statusSer.findAll();
	}
	
	/*
	 * Gets All designations
	 */
	@GetMapping("/designations")
	public List<DesignationDto> getDesignations() {
		return desigSer.findAll();
	}

	/*
	 * Gets All Districts along with state ID
	 */
	@GetMapping("/districts")
	public List<DistrictsDto> getDistrictsList() {
		return distSer.findAll();
	}
	
	/*
	 * Gets Districts belonging to particular state ID
	 */
	@GetMapping("/districts/{sId}")
	public List<DistrictsDto> getDistricts(@PathVariable("sId") Integer stateId) {
		return distSer.findByStateId(stateId);
	}
	
}
