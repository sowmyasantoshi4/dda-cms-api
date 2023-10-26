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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="staff_members")
@Getter
@Setter
public class StaffMembers{

	@Id
	@GeneratedValue(generator = "staff_members_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1,name = "staff_members_gen",sequenceName = "staff_members_seq", allocationSize = 1)
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="staff_name",length = 50,nullable = false)
	private String staffName;
	
	@ManyToOne
	@JoinColumn(name="designation_id",referencedColumnName = "designation_id",nullable = false)
	private Designation designationId;
	
	@Column(name="phone_no",length = 10,nullable = false)
	private String phoneNo;
	
	@Column(name="email_id",length = 50,nullable = false)
	private String emailId;
	
	@Column(name="house_no",length = 50,nullable = false)
	private String houseNo;
	
	@Column(name="street_no",length = 50,nullable = false)
	private String streetNo;
	
	@Column(name="city",length = 50,nullable = false)
	private String city;
	
	@Column(name="pincode",length = 6,nullable = false)
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="district_id",referencedColumnName = "district_id")
	private Districts staffDistrictId;
	
	@ManyToOne
	@JoinColumn(name="state_id",referencedColumnName = "state_id")
	private States staffStateId;
	
	@ManyToOne
	@JoinColumn(name="branch_id",referencedColumnName = "branch_id", nullable = true)
	private Branches staffBranchId;
	
	@OneToMany(mappedBy = "dispatchByStaffId")
	private List<Packages> dispatchByStaffId;
}
