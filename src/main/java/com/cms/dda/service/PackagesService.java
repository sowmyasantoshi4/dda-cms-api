package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.ItemsDto;
import com.cms.dda.dto.PackagesDto;
import com.cms.dda.dto.PackagesStatusDto;
import com.cms.dda.model.Packages;
import com.cms.dda.repo.PackagesRepo;


@Service
public class PackagesService {
	
	private static final Logger log = LoggerFactory.getLogger(PackagesService.class);

	@Autowired
	private PackagesRepo pkRepo;
	
	public List<PackagesDto> findAll() {
		log.info("In PackagesService :: findAll");
		return pkRepo.findAll()
				.stream()
				.map(t->new PackagesDto(t.getPackageId(), t.getReferenceNo()
						, t.getSenderName(), t.getSenderPhoneNo(), t.getSenderEmailId(), t.getSenderHouseNo(), t.getSenderStreetNo(), t.getSenderCity(), t.getSenderDistrictId().getDistrictId(), t.getSenderDistrictId().getDistrictName(), t.getSenderStateId().getStateId(), t.getSenderStateId().getStateName(), t.getSenderPincode()
						, t.getReceiverName(), t.getReceiverPhoneNo(), t.getReceiverEmailId(), t.getReceiverHouseNo(), t.getReceiverStreetNo(), t.getReceiverCity(), t.getReceiverDistrictId().getDistrictId(), t.getReceiverDistrictId().getDistrictName(), t.getReceiverStateId().getStateId(), t.getReceiverStateId().getStateName(), t.getReceiverPincode()
						, t.getPackagesStatusId().getStatusId(), t.getPackagesStatusId().getStatusName(), t.getRemarks()
						, ( null == t.getDispatchByStaffId() ? 0 : t.getDispatchByStaffId().getStaffId() )
						, ( null == t.getDispatchByStaffId() ? null : t.getDispatchByStaffId().getStaffName() )
						, t.getSendingBranchId().getBranchId(), t.getSendingBranchId().getBranchName()
						, t.getReceivingBranchId().getBranchId(), t.getReceivingBranchId().getBranchName(), t.getReceivedOn()
						, t.getItemsPackageId().stream()
									.map(m->new ItemsDto(m.getItemId(), m.getItemName(), m.getHeight(), m.getWeight(), m.getWidth(), m.getPrice())) // , m.getItemsPackageId().getPackageId()
									.sorted((o1, o2)->((Integer)o1.getItemId()).compareTo((Integer)o2.getItemId()))
									.collect(Collectors.toList())
						, t.getMapPackageId().stream()
									.map(n->new PackagesStatusDto(n.getMapStatusId().getStatusId(), n.getMapStatusId().getStatusName(), n.getStatusUpdatedOn(), n.getRemarks()))
											// n.getId(), n.getMapPackageId().getPackageId(), 
									.sorted((o1, o2)->((Integer)o1.getStatusId()).compareTo((Integer)o2.getStatusId()))
									.collect(Collectors.toList())
						)
				)
				.collect(Collectors.toList());
	}
	
	public PackagesDto findByReferenceNo(Integer refNo) {
		log.info("In PackagesService :: findByReferenceNo");
		Packages t = pkRepo.findByReferenceNo(refNo);
		PackagesDto pkDto = new PackagesDto(t.getPackageId(), t.getReferenceNo()
				, t.getSenderName(), t.getSenderPhoneNo(), t.getSenderEmailId(), t.getSenderHouseNo(), t.getSenderStreetNo(), t.getSenderCity(), t.getSenderDistrictId().getDistrictId(), t.getSenderDistrictId().getDistrictName(), t.getSenderStateId().getStateId(), t.getSenderStateId().getStateName(), t.getSenderPincode()
				, t.getReceiverName(), t.getReceiverPhoneNo(), t.getReceiverEmailId(), t.getReceiverHouseNo(), t.getReceiverStreetNo(), t.getReceiverCity(), t.getReceiverDistrictId().getDistrictId(), t.getReceiverDistrictId().getDistrictName(), t.getReceiverStateId().getStateId(), t.getReceiverStateId().getStateName(), t.getReceiverPincode()
				, t.getPackagesStatusId().getStatusId(), t.getPackagesStatusId().getStatusName(), t.getRemarks()
				, ( null == t.getDispatchByStaffId() ? 0 : t.getDispatchByStaffId().getStaffId() )
				, ( null == t.getDispatchByStaffId() ? null : t.getDispatchByStaffId().getStaffName() )
				, t.getSendingBranchId().getBranchId(), t.getSendingBranchId().getBranchName()
				, t.getReceivingBranchId().getBranchId(), t.getReceivingBranchId().getBranchName(), t.getReceivedOn()
				, t.getItemsPackageId().stream()
							.map(m->new ItemsDto(m.getItemId(), m.getItemName(), m.getHeight(), m.getWeight(), m.getWidth(), m.getPrice()))  //, m.getItemsPackageId().getPackageId()
							.sorted((o1, o2)->((Integer)o1.getItemId()).compareTo((Integer)o2.getItemId()))
							.collect(Collectors.toList())
				, t.getMapPackageId().stream()
							.map(n->new PackagesStatusDto(n.getMapStatusId().getStatusId(), n.getMapStatusId().getStatusName(), n.getStatusUpdatedOn(), n.getRemarks()))
							// n.getId(), n.getMapPackageId().getPackageId(), 
							.sorted((o1, o2)->((Integer)o1.getStatusId()).compareTo((Integer)o2.getStatusId()))
							.collect(Collectors.toList())
				);
		return pkDto;
		
	}
	
	
}
