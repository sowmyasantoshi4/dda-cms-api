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

import com.cms.dda.dto.BranchesDto;
import com.cms.dda.service.BranchesService;

@RestController
@RequestMapping("/branches")
public class BranchesController {
	
	@Autowired
	BranchesService branchesSer;
	
	@GetMapping("/all")
	public List<BranchesDto> getBranches() {
		return branchesSer.findAll();
	}
	
	@GetMapping("/byState/{sid}")
	public List<BranchesDto> getBranchesByStateId(@PathVariable Integer sid) {
		return branchesSer.findByStateId(sid);
	}
	
	@GetMapping("/byStateDist/{sid}/{did}")
	public List<BranchesDto> getBranchesByStateDistId(@PathVariable int sid, @PathVariable int did) {
		return branchesSer.findByStateDistrictId(sid, did);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addBranch(@RequestBody BranchesDto br){
		String brName = branchesSer.save(br);
		return new ResponseEntity<>(brName, HttpStatus.CREATED);
	}
}