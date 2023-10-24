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
public class PackagesStatusDto{

	private int id;
	
	private int packageId;
	
	private int statusId;
	
	private Date statusUpdatedOn;
	
	private String remarks;
	
}
