package com.cms.dda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="branches",uniqueConstraints = {@UniqueConstraint(columnNames = "branch_user_id",name="branch_user_id_uk")})
@Getter
@Setter
public class Branches{
	
	@Id
	@Column(name="branch_id")
	@GeneratedValue(generator = "branches_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1,name = "branches_gen",sequenceName = "branches_seq")
	private int branchId;
	
	@Column(name="branch_user_id",length = 25,nullable = false)
	private String branchUserId;
	
	@Column(name="incharge_staff_id",nullable = false)
	private int inchargeStaffId;

	@Column(name="branch_name",length = 100,nullable = false)
	private String branchName;
	
	@Column(name="phone_no",length = 25,nullable = false)
	private String phoneNo;
	
	@Column(name="email_id",length = 50,nullable = false)
	private String emailId;
	
	@Column(name="house_no",length = 50,nullable = false)
	private String houseNo;
	
	@Column(name="street_no",length = 50,nullable = false)
	private String streetNo;
	
	@Column(name="city",length = 50,nullable = false)
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "district_id",referencedColumnName = "district_id",nullable = false)
	private Districts branchDistrictId;

	@ManyToOne
	@JoinColumn(name="state_id",referencedColumnName = "state_id",nullable = false)
	private States branchStateId;
	
	@Column(name="pincode",nullable = false)
	private String pincode;
	
	@OneToMany(mappedBy = "staffBranchId")
	private List<StaffMembers> staffBranchId;
	
	@OneToMany(mappedBy = "sendingBranchId")
	private List<Packages> sendingBranchId;
	
	@OneToMany(mappedBy = "receivingBranchId")
	private List<Packages> receivingBranchId;
}
