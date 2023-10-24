package com.cms.dda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="states",uniqueConstraints = {@UniqueConstraint(name="state_name_uk",columnNames = {"state_name"})})
@Getter
@Setter
public class States{
	
	@Id
	@Column(name="state_id")
	private int stateId;
	
	@Column(name="state_name",length = 50,nullable = false)
	private String stateName;
	
	
	@OneToMany(mappedBy = "states")
	private List<Districts> districts;
	/*
	@OneToMany(mappedBy	= "branchStateId")
	private List<Branches> branchStateId;
	
	@OneToMany(mappedBy = "staffStateId")
	private List<StaffMembers> staffStateId;

	@OneToMany(mappedBy = "senderStateId")
	private List<Packages> senderStateId; 
	
	@OneToMany(mappedBy = "receiverStateId")
	private List<Packages> receiverStateId;
	*/
}
