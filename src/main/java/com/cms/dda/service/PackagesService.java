package com.cms.dda.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.dda.dto.ItemsDto;
import com.cms.dda.dto.PackagesDto;
import com.cms.dda.dto.PackagesStatusDto;
import com.cms.dda.dto.UpdatePackagesStatusDto;
import com.cms.dda.exception.GlobalException;
import com.cms.dda.model.Branches;
import com.cms.dda.model.Districts;
import com.cms.dda.model.GlobalReport;
import com.cms.dda.model.Items;
import com.cms.dda.model.Packages;
import com.cms.dda.model.PackagesStatus;
import com.cms.dda.model.StaffMembers;
import com.cms.dda.model.States;
import com.cms.dda.model.Status;
import com.cms.dda.repo.ItemsRepo;
import com.cms.dda.repo.PackageStatusRepo;
import com.cms.dda.repo.PackagesRepo;
import com.cms.dda.repo.StatusRepo;


@Service
public class PackagesService {
	
	private static final Logger log = LoggerFactory.getLogger(PackagesService.class);

	@Autowired
	private PackagesRepo pkRepo;
	
	@Autowired
	private PackageStatusRepo pksRepo;
	
	@Autowired
	private ItemsRepo pkiRepo;
	
	@Autowired
	private StatusRepo stRepo;
	
	@Autowired
	DistrictsService distSer;
	
	@Autowired
	StatesService stSer;
	
	@Autowired
	StatusService statusSer;
	
	@Autowired
	BranchesService brSer;
	
	@Autowired
	StaffMembersService smSer;
	
	
	public List<PackagesDto> findAll() {
		log.info("In PackagesService :: findAll");
		return pkRepo.findAll()
				.stream()
				.map(t->new PackagesDto(t.getPackageId(), t.getReferenceNo()
						, t.getSenderName(), t.getSenderPhoneNo(), t.getSenderEmailId(), t.getSenderHouseNo(), t.getSenderStreetNo(), t.getSenderCity(), t.getSenderDistrictId().getDistrictId(), t.getSenderDistrictId().getDistrictName(), t.getSenderStateId().getStateId(), t.getSenderStateId().getStateName(), t.getSenderPincode()
						, t.getReceiverName(), t.getReceiverPhoneNo(), t.getReceiverEmailId(), t.getReceiverHouseNo(), t.getReceiverStreetNo(), t.getReceiverCity(), t.getReceiverDistrictId().getDistrictId(), t.getReceiverDistrictId().getDistrictName(), t.getReceiverStateId().getStateId(), t.getReceiverStateId().getStateName(), t.getReceiverPincode()
						, t.getPackagesStatusId().getStatusId(), t.getPackagesStatusId().getStatusName()
						, ( null == t.getDispatchByStaffId() ? 0 : t.getDispatchByStaffId().getStaffId() )
						, ( null == t.getDispatchByStaffId() ? null : t.getDispatchByStaffId().getStaffName() )
						, t.getSendingBranchId().getBranchId(), t.getSendingBranchId().getBranchName()
						, t.getReceivingBranchId().getBranchId(), t.getReceivingBranchId().getBranchName(), t.getReceivedOn()
						, t.getItemsPackageId().stream()
									.map(m->new ItemsDto(m.getItemId(), m.getItemName(), m.getHeight(), m.getWeight(), m.getWidth(), m.getPrice())) // , m.getItemsPackageId().getPackageId()
									.sorted((o1, o2)->((Integer)o1.getItemId()).compareTo((Integer)o2.getItemId()))
									.collect(Collectors.toList())
						, t.getMapPackageId().stream()
									.map(n->new PackagesStatusDto(t.getReferenceNo(), n.getMapStatusId().getStatusId(), n.getMapStatusId().getStatusName(), n.getStatusUpdatedOn(), n.getRemarks()))
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
				, t.getPackagesStatusId().getStatusId(), t.getPackagesStatusId().getStatusName()
				, ( null == t.getDispatchByStaffId() ? 0 : t.getDispatchByStaffId().getStaffId() )
				, ( null == t.getDispatchByStaffId() ? null : t.getDispatchByStaffId().getStaffName() )
				, t.getSendingBranchId().getBranchId(), t.getSendingBranchId().getBranchName()
				, t.getReceivingBranchId().getBranchId(), t.getReceivingBranchId().getBranchName(), t.getReceivedOn()
				, t.getItemsPackageId().stream()
							.map(m->new ItemsDto(m.getItemId(), m.getItemName(), m.getHeight(), m.getWeight(), m.getWidth(), m.getPrice()))  //, m.getItemsPackageId().getPackageId()
							.sorted((o1, o2)->((Integer)o1.getItemId()).compareTo((Integer)o2.getItemId()))
							.collect(Collectors.toList())
				, t.getMapPackageId().stream()
							.map(n->new PackagesStatusDto(refNo, n.getMapStatusId().getStatusId(), n.getMapStatusId().getStatusName(), n.getStatusUpdatedOn(), n.getRemarks()))
							// n.getId(), n.getMapPackageId().getPackageId(), 
							.sorted((o1, o2)->((Integer)o1.getStatusId()).compareTo((Integer)o2.getStatusId()))
							.collect(Collectors.toList())
				);
		return pkDto;
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int save(PackagesDto pkReq) {
		int refNo = 0;
		Districts dist = null;
		States st = null;
		Branches br = null;
		Packages pk = null;
		Status status = null;
		List<Items> li = null;
		List<PackagesStatus> ls = null;
		try {
			pk = new Packages();
			BeanUtils.copyProperties(pkReq, pk);
			
			//pk.setSta(pkReq.getCurrentStatusId());
			
			dist = distSer.findById(pkReq.getSenderDistrictId())
					.orElseThrow(()->new GlobalException("District Id not found "+pkReq.getSenderDistrictId()));
			st = stSer.findById(pkReq.getSenderStateId())
					.orElseThrow(()->new GlobalException("State Id not found "+pkReq.getSenderStateId()));
			br = brSer.findById(pkReq.getSendingBranchId())
					.orElseThrow(()->new GlobalException("Sending Branch ID not found "+pkReq.getSendingBranchId()));
			pk.setSenderDistrictId(dist);
			pk.setSenderStateId(st);
			pk.setSendingBranchId(br);
			
			dist = distSer.findById(pkReq.getReceiverDistrictId())
					.orElseThrow(()->new GlobalException("District Id not foun "+pkReq.getReceiverDistrictId()));
			st = stSer.findById(pkReq.getReceiverStateId())
					.orElseThrow(()->new GlobalException("State Id not found"+pkReq.getReceiverStateId()));
			br = brSer.findById(pkReq.getReceivingBranchId())
					.orElseThrow(()->new GlobalException("Sending Branch ID not found "+pkReq.getReceivingBranchId()));
			pk.setReceiverDistrictId(dist);
			pk.setReceiverStateId(st);
			pk.setReceivingBranchId(br);
			
			status = statusSer.findById(pkReq.getCurrentStatusId())
					.orElseThrow(()->new GlobalException("Sending Branch ID not found "+pkReq.getCurrentStatusId()));
			pk.setPackagesStatusId(status);
			
			SimpleDateFormat dnt = new SimpleDateFormat("yyyyMMdd");
	        Date today = new Date();
//	        System.out.println("Today Date & Time at Now :"+dnt.format(today)); 
	        
			int count = (pkRepo.getPackagesOnDateCount(today))+1;
			String temp = dnt.format(today)+StringUtils.leftPad(count+"", 2, '0');
			refNo = Integer.parseInt(temp);
			
			pk.setReferenceNo(refNo);
			
			List<ItemsDto> liReq = pkReq.getPackageItems();
			if( liReq.size()>0 ) {
				li = new ArrayList<>();
				for (ItemsDto id : liReq) {
					Items i = new Items();
					i.setItemName(id.getItemName());
					i.setHeight(id.getHeight());
					i.setWeight(id.getWeight());
					i.setWidth(id.getWidth());
					i.setPrice(id.getPrice());
					i.setItemsPackageId(pk);
					li.add(i);
				}
				pk.setItemsPackageId(li);
				
			}
			
			List<PackagesStatusDto> lsReq = pkReq.getPackageStatuses();
			if( lsReq.size()>0 ) {
				ls = new ArrayList<>();
				for (PackagesStatusDto pd : lsReq) {
					PackagesStatus p = new PackagesStatus();
					p.setMapPackageId(pk);
					p.setMapStatusId(status);
					p.setRemarks(pd.getRemarks());
					ls.add(p);
				}
				pk.setMapPackageId(ls);
				
			}
			
			pkRepo.save(pk);
			pkiRepo.saveAll(li);
			pksRepo.saveAll(ls);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return refNo;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int updateStatus(UpdatePackagesStatusDto pkReq) {
		Packages pk = null;
		PackagesStatus pks = null;
		StaffMembers sm = null;
		Status st = null;
		int refNo = 0, resRefNo = 0;
		int statusId = 0;
		try {
			pks = new PackagesStatus();
			st = new Status();
			
			refNo = pkReq.getReferenceNo();
			statusId = pkReq.getStatusId();
			
			pk = pkRepo.findByReferenceNo(refNo);
					//.orElseThrow(()->new GlobalException("Package Ref No. not found "));
			st = stRepo.findById(statusId)
					.orElseThrow(()->new GlobalException("Status ID not found "));
			pk.setPackagesStatusId(st);
			if( statusId == 4 ){ // Delivered
				int dispacthStaffId = pkReq.getDispatchStaffId();
				sm = new StaffMembers();
				sm = smSer.findById(dispacthStaffId)
						.orElseThrow(()->new GlobalException("Staff id not forund"));
				pk.setDispatchByStaffId(sm);
			}
			
			pks.setMapPackageId(pk);
			pks.setMapStatusId(st);
			pks.setRemarks(pkReq.getRemarks());
			
			resRefNo = pkRepo.save(pk).getReferenceNo();
			pksRepo.save(pks);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return resRefNo;
	}
	
	public List<PackagesDto> getGlobalReport(GlobalReport grReq){
		Packages pk = null;
		int refNo = 0;
		int statusId = 0;
		int fromBranchId = 0;
		int toBranchId = 0;
		//String fromDt = null;
		//String toDt = null;
		Status st = null;
		Branches br = null;
		List<PackagesDto> reportData = null;
		try {
			refNo = grReq.getReferenceNo();
			statusId = grReq.getStatusId();
			fromBranchId = grReq.getFromBranchId();
			toBranchId = grReq.getToBranchId();
			//fromDt = grReq.getFromDate();
			//toDt = grReq.getToDate();
			
			pk = new Packages();
			if( refNo>0 ) {
				pk.setReferenceNo(grReq.getReferenceNo());
			}
			if( statusId>0 ) {
				st = stRepo.findById(statusId)
						.orElseThrow(()->new GlobalException("Status ID not found "));
				pk.setPackagesStatusId(st);
			}
			if( fromBranchId>0 ) {
				br = brSer.findById(fromBranchId)
						.orElseThrow(()->new GlobalException("Sending from Branch ID not found "));
				pk.setSendingBranchId(br);
			}
			if( toBranchId>0 ) {
				br = brSer.findById(toBranchId)
						.orElseThrow(()->new GlobalException("Sending to Branch ID not found "));
				pk.setReceivingBranchId(br);
			}
			
			Example<Packages> example = Example.of(pk);
			reportData = pkRepo.findAll(example).stream()
						.map(t->new PackagesDto(t.getPackageId(), t.getReferenceNo()
								, t.getSenderName(), t.getSenderPhoneNo(), t.getSenderEmailId(), t.getSenderHouseNo(), t.getSenderStreetNo(), t.getSenderCity(), t.getSenderDistrictId().getDistrictId(), t.getSenderDistrictId().getDistrictName(), t.getSenderStateId().getStateId(), t.getSenderStateId().getStateName(), t.getSenderPincode()
								, t.getReceiverName(), t.getReceiverPhoneNo(), t.getReceiverEmailId(), t.getReceiverHouseNo(), t.getReceiverStreetNo(), t.getReceiverCity(), t.getReceiverDistrictId().getDistrictId(), t.getReceiverDistrictId().getDistrictName(), t.getReceiverStateId().getStateId(), t.getReceiverStateId().getStateName(), t.getReceiverPincode()
								, t.getPackagesStatusId().getStatusId(), t.getPackagesStatusId().getStatusName()
								, ( null == t.getDispatchByStaffId() ? 0 : t.getDispatchByStaffId().getStaffId() )
								, ( null == t.getDispatchByStaffId() ? null : t.getDispatchByStaffId().getStaffName() )
								, t.getSendingBranchId().getBranchId(), t.getSendingBranchId().getBranchName()
								, t.getReceivingBranchId().getBranchId(), t.getReceivingBranchId().getBranchName(), t.getReceivedOn()
								, t.getItemsPackageId().stream()
											.map(m->new ItemsDto(m.getItemId(), m.getItemName(), m.getHeight(), m.getWeight(), m.getWidth(), m.getPrice())) // , m.getItemsPackageId().getPackageId()
											.sorted((o1, o2)->((Integer)o1.getItemId()).compareTo((Integer)o2.getItemId()))
											.collect(Collectors.toList())
								, t.getMapPackageId().stream()
											.map(n->new PackagesStatusDto(t.getReferenceNo(), n.getMapStatusId().getStatusId(), n.getMapStatusId().getStatusName(), n.getStatusUpdatedOn(), n.getRemarks()))
													// n.getId(), n.getMapPackageId().getPackageId(), 
											.sorted((o1, o2)->((Integer)o1.getStatusId()).compareTo((Integer)o2.getStatusId()))
											.collect(Collectors.toList())
								)
						)
						.collect(Collectors.toList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reportData;
		
	}
	
	
}
