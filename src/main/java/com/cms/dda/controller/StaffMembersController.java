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

import com.cms.dda.dto.StaffMembersDto;
import com.cms.dda.service.StaffMembersService;


@RestController
@RequestMapping("/staffMembers")
public class StaffMembersController {
	
	@Autowired
	StaffMembersService smSer;
	
	/*
	 * Get Alls Staff Members
	 */
	@GetMapping("/all")
	public List<StaffMembersDto> getStaffMembers() {
		return smSer.findAll();
	}
	
	/*
	 * Get Alls Staff Members of particular branch Id
	 */
	@GetMapping("/byBranch/{bid}")
	public List<StaffMembersDto> getStaffMembersByBranchId(@PathVariable Integer bid) {
		return smSer.findByBranchId(bid);
	}
	
	/*
	 * Get Alls Staff Members of particular branch Id
	 */
	@GetMapping("/byDesignation/{did}")
	public List<StaffMembersDto> getStaffMembersByDesigId(@PathVariable Integer did) {
		return smSer.findByDesigId(did);
	}
	
	/*
	 * Get Alls Staff Members of particular branch Id and designation Id
	 */
	@GetMapping("/byBranchDesignation/{bid}/{did}")
	public List<StaffMembersDto> getStaffMembersByDesigId(@PathVariable Integer bid, @PathVariable Integer did) {
		return smSer.findByBranchDesigId(bid, did);
	}
	
	/*
	 * Save Staff Members -> branch Id can be null which is added at the time of branch
	 */
	@PostMapping("/add")
	public ResponseEntity<?> addStaffMember(@RequestBody StaffMembersDto sm ) {
		String staffName = smSer.save(sm);
		return new ResponseEntity<>(staffName,HttpStatus.CREATED);
	}
	
	
	
}
