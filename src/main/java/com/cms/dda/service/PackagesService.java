package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.PackagesDto;
import com.cms.dda.repo.PackagesRepo;


@Service
public class PackagesService {
	
	private static final Logger log = LoggerFactory.getLogger(PackagesService.class);

	@Autowired
	private PackagesRepo pkRepo;
	
	public List<PackagesDto> findAll() {
		log.info("In StaffMembersService :: findAll");
		return pkRepo.findAll()
				.stream()
				.map(t->new PackagesDto(t.getPackageId(), t.getReferenceNo()
						, t.getSenderName(), t.getSenderPhoneNo(), t.getSenderEmailId(), t.getSenderHouseNo(), t.getSenderStreetNo(), t.getSenderCity(), t.getSenderDistrictId().getDistrictId(), t.getSenderStateId().getStateId(), t.getSenderPincode()
						, t.getReceiverName(), t.getReceiverPhoneNo(), t.getReceiverEmailId(), t.getReceiverHouseNo(), t.getReceiverStreetNo(), t.getReceiverCity(), t.getReceiverDistrictId().getDistrictId(), t.getReceiverStateId().getStateId(), t.getReceiverPincode()
						, t.getPackagesStatusId().getStatusId(), t.getRemarks()
						, ( null == t.getDispatchByStaffId() ? 0 : t.getDispatchByStaffId().getStaffId() )
						, t.getSendingBranchId().getBranchId(), t.getReceivingBranchId().getBranchId()
						, t.getItemsPackageId(), t.getMapPackageId()
						))
				.collect(Collectors.toList());
	}
	
	/*
	public List<StaffMembersDto> findByBranchId(Integer branchId) {
		log.info("In StaffMembersService :: findByBranchId");
		return pkRepo.findByBranchId(branchId)
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getPhoneNo(), t.getEmailId()
						, t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getStaffDistrictId().getDistrictId(), t.getStaffStateId().getStateId(), t.getStaffBranchId().getBranchId())
				)
				.collect(Collectors.toList());
	}
	
	public List<StaffMembersDto> findByDesigId(Integer desigId) {
		log.info("In StaffMembersService :: findByDesigId");
		return pkRepo.findByDesigId(desigId)
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getPhoneNo(), t.getEmailId()
						, t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getStaffDistrictId().getDistrictId(), t.getStaffStateId().getStateId(), t.getStaffBranchId().getBranchId())
				)
				.collect(Collectors.toList());
	}
	
	public List<StaffMembersDto> findByBranchDesigId(Integer branchId, Integer desigId) {
		log.info("In StaffMembersService :: findStaffMembersByDesigId");
		return pkRepo.findByBranchDesignationId(branchId, desigId)
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getPhoneNo(), t.getEmailId()
						, t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getStaffDistrictId().getDistrictId(), t.getStaffStateId().getStateId(), t.getStaffBranchId().getBranchId())
				)
				.collect(Collectors.toList());
	}
	*/
}
