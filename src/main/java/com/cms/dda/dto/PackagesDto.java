package com.cms.dda.dto;

import java.util.Date;
import java.util.List;

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
	
	private String senderPhoneNo;
	
	private String senderEmailId;
	
	private String senderHouseNo;
	
	private String senderStreetNo;
	
	private String senderCity;
	
	private int senderDistrictId;
	
	private String senderDistrictName;
	
	private int  senderStateId;
	
	private String senderStateName;
	
	private String senderPincode;
	
	private String receiverName;
	
	private String receiverPhoneNo;
	
	private String receiverEmailId;
	
	private String receiverHouseNo;
	
	private String receiverStreetNo;
	
	private String receiverCity;
	
	private int  receiverDistrictId;
	
	private String receiverDistrictName;
	
	private int receiverStateId;
	
	private String receiverStateName;
	
	private String  receiverPincode;
	
	private int currentStatusId;
	
	private String  currentStatusName;
	
	private String  remarks;
	
	private int dispatchByStaffId;
	
	private String  dispatchByStaffName;
	
	private int sendingBranchId;
	
	private String  sendingBranchName;
	
	private int receivingBranchId;
	
	private String  receivingBranchName;
	
	private Date receivedOn;

	private List<ItemsDto> packageItems;
	
	private List<PackagesStatusDto> packageStatuses;
	
}
