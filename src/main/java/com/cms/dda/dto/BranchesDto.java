package com.cms.dda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchesDto{
	
	private int branchId;
	
	private String branchUserId;
	
	private int inchargeStaffId;

	private String branchName;
	
	private String phoneNo;
	
	private String emailId;
	
	private String houseNo;
	
	private String streetNo;
	
	private String city;
	
	private int branchDistrictId;

	private int branchStateId;
	
	private String pincode;
	
	
}
