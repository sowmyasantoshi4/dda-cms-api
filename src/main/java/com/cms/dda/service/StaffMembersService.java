package com.cms.dda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.StaffMembersDto;
import com.cms.dda.exception.GlobalException;
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
	
	@Autowired
	private DesignationService desigSer;
	
	@Autowired
	private DistrictsService distSer;
	
	@Autowired
	private StatesService stSer;
	
	
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
	
	public Optional<StaffMembers> findById(Integer staffId){
		return smRepo.findById(staffId);
	}
	
	public String save(StaffMembersDto smReq) {
		log.info("In StaffMembersService :: save");
		StaffMembers sm = null;
		Designation desig = null;
		Districts dist = null;
		States st = null;
		try{
			sm = new StaffMembers();
			BeanUtils.copyProperties(smReq, sm);
			
			desig = desigSer.findByOneDesigId(smReq.getDesignationId())
					.orElseThrow(()->new GlobalException("Designation not found "+smReq.getDesignationId()));
			
			dist = distSer.findById(smReq.getDistrictId())
					.orElseThrow(()->new GlobalException("District not found "+smReq.getDistrictId()));
			
			st = stSer.findById(smReq.getStateId())
					.orElseThrow(()->new GlobalException("State not found "+smReq.getStateId()));
			
			sm.setDesignationId(desig);
			sm.setStaffDistrictId(dist);
			sm.setStaffStateId(st);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return smRepo.save(sm).getStaffName();
	}
}
