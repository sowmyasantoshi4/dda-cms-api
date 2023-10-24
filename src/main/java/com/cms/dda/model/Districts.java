package com.cms.dda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="districts",uniqueConstraints = { 
		@UniqueConstraint(name="district_name_uk",columnNames = {"district_name"}),
		@UniqueConstraint(name="state_district_id_uk",columnNames = {"district_id","state_id"})
	}
)
@Getter
@Setter
public class Districts{
	
	@Id
	@Column(name="district_id")
	private int districtId;
	
	@Column(name="district_name",length = 50,nullable = false)
	private String districtName;
	
	@ManyToOne
	@JoinColumn(name = "state_id",nullable = false, referencedColumnName = "state_id")
	private States states;
	
	@OneToMany(mappedBy = "branchDistrictId")
	private List<Branches> branchDistrictId;
	
	@OneToMany(mappedBy = "staffDistrictId")
	private List<StaffMembers> staffDistrictId;
	
	@OneToMany(mappedBy = "senderDistrictId")
	private List<Packages> senderDistrictId;

	@OneToMany(mappedBy = "receiverDistrictId")
	private List<Packages> receiverDistrictId;
}
