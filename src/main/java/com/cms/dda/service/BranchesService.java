package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.BranchesDto;
import com.cms.dda.repo.BranchesRepo;


@Service
public class BranchesService {
	
	private static final Logger log = LoggerFactory.getLogger(BranchesService.class);

	@Autowired
	private BranchesRepo brRepo;
	
	
	public List<BranchesDto> findAll() {
		log.info("In BranchesService :: findAll");
		return brRepo.findAll().stream()
				.map(t->new BranchesDto(t.getBranchId(),t.getBranchUserId(), t.getInchargeStaffId(), t.getBranchName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getBranchDistrictId().getDistrictId()
						, t.getBranchStateId().getStateId(), t.getPincode()))
				.collect(Collectors.toList());
	}
	
	public List<BranchesDto> findByStateId(Integer stateId) {
		log.info("In BranchesService :: findByStateId");
		return brRepo.findByBranchStateId(stateId).stream()
				.map(t->new BranchesDto(t.getBranchId(),t.getBranchUserId(), t.getInchargeStaffId(), t.getBranchName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getBranchDistrictId().getDistrictId()
						, t.getBranchStateId().getStateId(), t.getPincode()))
				.collect(Collectors.toList());
	}
	
	public List<BranchesDto> findByStateDistrictId(Integer stateId, Integer branchId) {
		log.info("In BranchesService :: findByStateDistrictId");
		return brRepo.findByStateDistrictId(stateId, branchId).stream()
				.map(t->new BranchesDto(t.getBranchId(),t.getBranchUserId(), t.getInchargeStaffId(), t.getBranchName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getBranchDistrictId().getDistrictId()
						, t.getBranchStateId().getStateId(), t.getPincode()))
				.collect(Collectors.toList());
	}
	
}
