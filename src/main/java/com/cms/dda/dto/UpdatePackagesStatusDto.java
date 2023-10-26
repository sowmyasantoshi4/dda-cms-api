package com.cms.dda.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePackagesStatusDto{

//	private int id;
	
	private int referenceNo;
	
	private int statusId;
	
	private String statusName;
	
	private Date statusUpdatedOn;
	
	private String remarks;
	
	private int dispatchStaffId;
	
}
