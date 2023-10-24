package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.DesignationDto;
import com.cms.dda.dto.StaffMembersDto;
import com.cms.dda.model.Designation;
import com.cms.dda.model.Districts;
import com.cms.dda.model.StaffMembers;
import com.cms.dda.model.States;
import com.cms.dda.repo.StaffMembersRepo;


@Service
public class StaffMembersService {
	
	private static final Logger log = LoggerFactory.getLogger(StaffMembersService.class);

	@Autowired
	private StaffMembersRepo smRepo;
	
	public List<StaffMembersDto> findAll() {
		log.info("In StaffMembersService :: findAll");
		log.info("size="+smRepo.findAll().size());
		return smRepo.findAll()
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getDesignationId().getDesignationName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity()
						, ( null == t.getStaffDistrictId() ? 0 : t.getStaffDistrictId().getDistrictId() )
						, ( null == t.getStaffDistrictId() ? null : t.getStaffDistrictId().getDistrictName() )
						, ( null == t.getStaffStateId() ? 0 : t.getStaffStateId().getStateId() ) 
						, ( null == t.getStaffStateId() ? null : t.getStaffStateId().getStateName() ) 
						, ( null == t.getStaffBranchId() ? 0 : t.getStaffBranchId().getBranchId() ) 
						, ( null == t.getStaffBranchId() ? null : t.getStaffBranchId().getBranchName() ) 
						, t.getPincode()
						))
				.collect(Collectors.toList());
	}
	
	public List<StaffMembersDto> findByBranchId(Integer branchId) {
		log.info("In StaffMembersService :: findByBranchId");
		return smRepo.findByBranchId(branchId)
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getDesignationId().getDesignationName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity()
						, ( null == t.getStaffDistrictId() ? 0 : t.getStaffDistrictId().getDistrictId() )
						, ( null == t.getStaffDistrictId() ? null : t.getStaffDistrictId().getDistrictName() )
						, ( null == t.getStaffStateId() ? 0 : t.getStaffStateId().getStateId() ) 
						, ( null == t.getStaffStateId() ? null : t.getStaffStateId().getStateName() ) 
						, ( null == t.getStaffBranchId() ? 0 : t.getStaffBranchId().getBranchId() ) 
						, ( null == t.getStaffBranchId() ? null : t.getStaffBranchId().getBranchName() ) 
						, t.getPincode()
						))
				.collect(Collectors.toList());
	}
	
	public List<StaffMembersDto> findByDesigId(Integer desigId) {
		log.info("In StaffMembersService :: findByDesigId");
		return smRepo.findByDesigId(desigId)
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getDesignationId().getDesignationName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity()
						, ( null == t.getStaffDistrictId() ? 0 : t.getStaffDistrictId().getDistrictId() )
						, ( null == t.getStaffDistrictId() ? null : t.getStaffDistrictId().getDistrictName() )
						, ( null == t.getStaffStateId() ? 0 : t.getStaffStateId().getStateId() ) 
						, ( null == t.getStaffStateId() ? null : t.getStaffStateId().getStateName() ) 
						, ( null == t.getStaffBranchId() ? 0 : t.getStaffBranchId().getBranchId() ) 
						, ( null == t.getStaffBranchId() ? null : t.getStaffBranchId().getBranchName() ) 
						, t.getPincode()
						))
				.collect(Collectors.toList());
	}
	
	public List<StaffMembersDto> findByBranchDesigId(Integer branchId, Integer desigId) {
		log.info("In StaffMembersService :: findStaffMembersByDesigId");
		return smRepo.findByBranchDesignationId(branchId, desigId)
				.stream()
				.map(t->new StaffMembersDto(t.getStaffId(), t.getStaffName(), t.getDesignationId().getDesignationId(), t.getDesignationId().getDesignationName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity()
						, ( null == t.getStaffDistrictId() ? 0 : t.getStaffDistrictId().getDistrictId() )
						, ( null == t.getStaffDistrictId() ? null : t.getStaffDistrictId().getDistrictName() )
						, ( null == t.getStaffStateId() ? 0 : t.getStaffStateId().getStateId() ) 
						, ( null == t.getStaffStateId() ? null : t.getStaffStateId().getStateName() ) 
						, ( null == t.getStaffBranchId() ? 0 : t.getStaffBranchId().getBranchId() ) 
						, ( null == t.getStaffBranchId() ? null : t.getStaffBranchId().getBranchName() ) 
						, t.getPincode()
						))
				.collect(Collectors.toList());
	}
	
	public ResponseEntity save(StaffMembersDto smReq) {
		log.info("In StaffMembersService :: save");
		StaffMembers sm = null;
		
		ResponseEntity re = new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		
		try{
			sm = new StaffMembers();
			sm.setStaffName(smReq.getName());
			sm.setPhoneNo(smReq.getPhoneNo());
			sm.setEmailId(smReq.getEmailId());
			sm.setHouseNo(smReq.getHouseNo());
			sm.setCity(smReq.getCity());
			sm.setStreetNo(smReq.getStreetNo());
			
			Districts dist = new Districts();
			dist.setDistrictId(smReq.getDistrictId());
			sm.setStaffDistrictId(dist);
			
			States st = new States();
			st.setStateId(smReq.getStateId());
			sm.setStaffStateId(st);
			
			Designation desig = new Designation();
			desig.setDesignationId(smReq.getDesignationId());
			sm.setDesignationId(desig);
			
			re = new ResponseEntity<>(smRepo.save(sm), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return re;
	}
}
