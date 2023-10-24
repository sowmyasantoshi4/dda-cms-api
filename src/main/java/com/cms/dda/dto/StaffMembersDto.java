package com.cms.dda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffMembersDto{

	private int id;
	
	private String name;
	
	private int designationId;
	
	private String designationName;
	
	private String phoneNo;
	
	private String emailId;
	
	private String houseNo;
	
	private String streetNo;
	
	private String city;
	
	private int districtId;
	
	private String districtName;
	
	private int stateId;
	
	private String stateName;
	
	private int branchId;
	
	private String branchName;
	
	private String pincode;

	/*
	public StaffMembersDto(int staffId, String staffName, int designationId, String phoneNo, String emailId,
			String houseNo, String streetNo, String city, int staffDistrictId, int staffStateId, int staffBranchId) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.designationId = designationId;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.houseNo = houseNo;
		this.streetNo = streetNo;
		this.city = city;
		this.staffDistrictId = staffDistrictId;
		this.staffStateId = staffStateId;
		this.staffBranchId = staffBranchId;
	}
	*/
}
