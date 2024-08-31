package com.cms.dda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.dda.dto.BranchesDto;
import com.cms.dda.dto.StaffMembersDto;
import com.cms.dda.exception.GlobalException;
import com.cms.dda.model.Branches;
import com.cms.dda.model.Districts;
import com.cms.dda.model.StaffMembers;
import com.cms.dda.model.States;
import com.cms.dda.repo.BranchesRepo;
import com.cms.dda.repo.StaffMembersRepo;


@Service
public class BranchesService {
	
	private static final Logger log = LoggerFactory.getLogger(BranchesService.class);

	@Autowired
	private BranchesRepo brRepo;
	
	@Autowired
	private StaffMembersRepo smRepo;
	
	@Autowired
	DistrictsService distSer;
	
	@Autowired
	StatesService stSer;
	
	@Autowired
	StaffMembersService smSer;
	
	
	public List<BranchesDto> findAll() {
		log.info("In BranchesService :: findAll");
		return brRepo.findAll().stream()
				.map(t->new BranchesDto(t.getBranchId(),t.getBranchUserId(), t.getInchargeStaffId().getStaffId(), t.getInchargeStaffId().getStaffName(), t.getBranchName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getBranchDistrictId().getDistrictId(), t.getBranchDistrictId().getDistrictName()
						, t.getBranchStateId().getStateId(), t.getBranchStateId().getStateName(), t.getPincode()
						, t.getStaffBranchId().stream()
							.map(m->new StaffMembersDto(m.getStaffId(), m.getStaffName(), m.getDesignationId().getDesignationId(), m.getDesignationId().getDesignationName(), m.getPhoneNo(), m.getEmailId(), m.getHouseNo(), m.getStreetNo(), m.getCity(), m.getStaffDistrictId().getDistrictId(), m.getStaffDistrictId().getDistrictName(), m.getStaffStateId().getStateId(), m.getStaffStateId().getStateName(), m.getStaffBranchId().getBranchId(), m.getStaffBranchId().getBranchName(), m.getPincode()))
							.sorted((o1, o2)->((Integer)o1.getDesignationId()).compareTo((Integer)o2.getDesignationId()))
							.collect(Collectors.toList())
					))
				.collect(Collectors.toList());
	}
	
	public List<BranchesDto> findByStateId(Integer stateId) {
		log.info("In BranchesService :: findByStateId");
		return brRepo.findByBranchStateId(stateId).stream()
				.map(t->new BranchesDto(t.getBranchId(),t.getBranchUserId(), t.getInchargeStaffId().getStaffId(), t.getInchargeStaffId().getStaffName(), t.getBranchName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getBranchDistrictId().getDistrictId(), t.getBranchDistrictId().getDistrictName()
						, t.getBranchStateId().getStateId(), t.getBranchStateId().getStateName(), t.getPincode()
						, t.getStaffBranchId().stream()
							.map(m->new StaffMembersDto(m.getStaffId(), m.getStaffName(), m.getDesignationId().getDesignationId(), m.getDesignationId().getDesignationName(), m.getPhoneNo(), m.getEmailId(), m.getHouseNo(), m.getStreetNo(), m.getCity(), m.getStaffDistrictId().getDistrictId(), m.getStaffDistrictId().getDistrictName(), m.getStaffStateId().getStateId(), m.getStaffStateId().getStateName(), m.getStaffBranchId().getBranchId(), m.getStaffBranchId().getBranchName(), m.getPincode()))
							.sorted((o1, o2)->((Integer)o1.getDesignationId()).compareTo((Integer)o2.getDesignationId()))
							.collect(Collectors.toList())
					))
				.collect(Collectors.toList());
	}
	
	public List<BranchesDto> findByStateDistrictId(Integer stateId, Integer branchId) {
		log.info("In BranchesService :: findByStateDistrictId");
		return brRepo.findByStateDistrictId(stateId, branchId).stream()
				.map(t->new BranchesDto(t.getBranchId(),t.getBranchUserId(), t.getInchargeStaffId().getStaffId(), t.getInchargeStaffId().getStaffName(), t.getBranchName()
						, t.getPhoneNo(), t.getEmailId(), t.getHouseNo(), t.getStreetNo(), t.getCity(), t.getBranchDistrictId().getDistrictId(), t.getBranchDistrictId().getDistrictName()
						, t.getBranchStateId().getStateId(), t.getBranchStateId().getStateName(), t.getPincode()
						, t.getStaffBranchId().stream()
							.map(m->new StaffMembersDto(m.getStaffId(), m.getStaffName(), m.getDesignationId().getDesignationId(), m.getDesignationId().getDesignationName(), m.getPhoneNo(), m.getEmailId(), m.getHouseNo(), m.getStreetNo(), m.getCity(), m.getStaffDistrictId().getDistrictId(), m.getStaffDistrictId().getDistrictName(), m.getStaffStateId().getStateId(), m.getStaffStateId().getStateName(), m.getStaffBranchId().getBranchId(), m.getStaffBranchId().getBranchName(), m.getPincode()))
							.sorted((o1, o2)->((Integer)o1.getDesignationId()).compareTo((Integer)o2.getDesignationId()))
							.collect(Collectors.toList())
					))
				.collect(Collectors.toList());
	}
	
	public Optional<Branches> findById(int branchId){
		return brRepo.findById(branchId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String save(BranchesDto brReq) {
		log.info("In BranchesService :: save");
		Branches br = null;
		Districts dist = null;
		States st = null;
		StaffMembers sm = null;
		String brUserId = null, brName = null;
		List<StaffMembers> ls = null;
		
		try {
			br = new Branches();
			BeanUtils.copyProperties(brReq, br);
			
			dist = distSer.findById(brReq.getDistrictId())
					.orElseThrow(()->new GlobalException("District Id not foun "+brReq.getDistrictId()));
			
			st = stSer.findById(brReq.getStateId())
					.orElseThrow(()->new GlobalException("State Id not found"+brReq.getStateId()));
			
			int count = ((int)brRepo.count())+1;
			brUserId = "branch-"+StringUtils.leftPad(count+"", 2, '0');
			
			br.setBranchDistrictId(dist);
			br.setBranchStateId(st);
			br.setBranchUserId(brUserId);
			
			sm = smSer.findById(brReq.getInchargeStaffId())
					.orElseThrow(()->new GlobalException("Incharge Staff Id not found "+brReq.getInchargeStaffId()));
			sm.setStaffBranchId(br);
			br.setInchargeStaffId(sm);
			
			List<StaffMembersDto> lsReq = brReq.getStaff();
			if( lsReq.size()>0 ) {
				ls = new ArrayList<>();
				for (StaffMembersDto smd : lsReq) {
					StaffMembers i = new StaffMembers();
					i = smSer.findById(smd.getStaffId())
							.orElseThrow(()->new GlobalException("Staff Id not found "+brReq.getStateId()));
					i.setStaffBranchId(br);
					ls.add(i);
				}
				br.setStaffBranchId(ls);
			}
			
			brName = brRepo.save(br).getBranchName();
			smRepo.saveAll(ls);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return brName;
	}
	
}
