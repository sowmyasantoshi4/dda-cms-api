package com.cms.dda.dto;

import java.util.List;

import com.cms.dda.model.Branches;
import com.cms.dda.model.Items;
import com.cms.dda.model.PackagesStatus;
import com.cms.dda.model.StaffMembers;
import com.cms.dda.model.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PackagesDto{
	
	

	private int packageId;
	
	private int referenceNo;
	
	private String senderName;
	
//	private String senderAddress;
	
	private String senderPhoneNo;
	
	private String senderEmailId;
	
	private String senderHouseNo;
	
	private String senderStreetNo;
	
	private String senderCity;
	
	private int senderDistrictId;
	
	private int  senderStateId;
	
	private String senderPincode;
	
	private String receiverName;
	
//	private String receiverAddress;
	
	private String receiverPhoneNo;
	
	private String receiverEmailId;
	
	private String receiverHouseNo;
	
	private String receiverStreetNo;
	
	private String receiverCity;
	
	private int  receiverDistrictId;
	
	private int receiverStateId;
	
	private String  receiverPincode;
	
	private int packagesStatusId;
	
	private String  remarks;
	
	private int dispatchByStaffId;
	
	private int sendingBranchId;
	
	private int receivingBranchId;

	private List<Items> packageItems;
	
	private List<PackagesStatus> packageStatuses;
	
	/*
	 * 
	public PackagesDto(int packageId2, int referenceNo2, String senderName2, String sender_phone_no,String senderEmailId2, 
			String senderHouseNo2, String senderStreetNo2, String sender_city, int districtId,
			int stateId, String receiverName2, String receiverPhoneNo2, String receiverEmailId2,
			String receiverHouseNo2, String receiverStreetNo2, int districtId2, int stateId2, String receiverPincode2,
			Status packagesStatusId2, String remarks2, StaffMembers dispatchByStaffId2, Branches sendingBranchId2,
			Branches receivingBranchId2, List<Items> itemsPackageId, List<PackagesStatus> mapPackageId) {
		// TODO Auto-generated constructor stub
	}

	public PackagesDto(int packageId, int referenceNo, String senderName, String senderPhoneNo, String senderEmailId,
			String senderHouseNo, String senderStreetNo, String senderCity, int senderDistrictId, int senderStateId,
			String senderPincode, String receiverName, String receiverPhoneNo, String receiverEmailId,
			String receiverHouseNo, String receiverStreetNo, String receiverCity, int receiverDistrictId,
			int receiverStateId, String receiverPincode, int packagesStatusId, String remarks, int dispatchByStaffId,
			int sendingBranchId, int receivingBranchId, List<Items> packageItems,
			List<PackagesStatus> packageStatuses) {
		super();
		this.packageId = packageId;
		this.referenceNo = referenceNo;
		this.senderName = senderName;
		this.senderPhoneNo = senderPhoneNo;
		this.senderEmailId = senderEmailId;
		this.senderHouseNo = senderHouseNo;
		this.senderStreetNo = senderStreetNo;
		this.senderCity = senderCity;
		this.senderDistrictId = senderDistrictId;
		this.senderStateId = senderStateId;
		this.senderPincode = senderPincode;
		this.receiverName = receiverName;
		this.receiverPhoneNo = receiverPhoneNo;
		this.receiverEmailId = receiverEmailId;
		this.receiverHouseNo = receiverHouseNo;
		this.receiverStreetNo = receiverStreetNo;
		this.receiverCity = receiverCity;
		this.receiverDistrictId = receiverDistrictId;
		this.receiverStateId = receiverStateId;
		this.receiverPincode = receiverPincode;
		this.packagesStatusId = packagesStatusId;
		this.remarks = remarks;
		this.dispatchByStaffId = dispatchByStaffId;
		this.sendingBranchId = sendingBranchId;
		this.receivingBranchId = receivingBranchId;
		this.packageItems = packageItems;
		this.packageStatuses = packageStatuses;
	}
	*/
	
	
	
}
