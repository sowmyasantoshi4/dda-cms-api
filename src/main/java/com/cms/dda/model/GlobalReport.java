package com.cms.dda.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalReport {
	
	private String fromDate;
	private String toDate;
	private int fromBranchId;
	private int toBranchId;
	private int statusId;
	
//	@Id
	private int referenceNo;

}
