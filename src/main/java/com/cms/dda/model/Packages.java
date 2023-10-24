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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="packages")
@Getter
@Setter
public class Packages{

	@Id
	@GeneratedValue(generator = "packages_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1,name = "packages_gen",sequenceName = "packages_seq")
	@Column(name="package_id")
	private int packageId;
	
	@Column(name="reference_no",unique = true,nullable = false)
	private int referenceNo;
	
	@Column(name="sender_name",length = 50,nullable = false)
	private String  senderName;
	
//	@Column(name="sender_address",length = 250,nullable = false)
//	private String senderAddress;
	
	@Column(name="sender_phone_no",length = 25,nullable = false)
	private String  senderPhoneNo;
	
	@Column(name="sender_email_id",length = 50,nullable = false)
	private String senderEmailId;
	
	@Column(name="sender_house_no",length = 50,nullable = false)
	private String senderHouseNo;
	
	@Column(name="sender_street_no",length = 50,nullable = false)
	private String senderStreetNo;
	
	@Column(name="sender_city",length = 50,nullable = false)
	private String senderCity;
	
	@ManyToOne
	@JoinColumn(name="sender_district_id",referencedColumnName = "district_id",nullable = false)
	private Districts senderDistrictId;
	
	@ManyToOne
	@JoinColumn(name="sender_state_id",referencedColumnName = "state_id",nullable = false )
	private States  senderStateId;
	
	@Column(name="sender_pincode",length = 10,nullable = false)
	private String  senderPincode;
	
	@Column(name="receiver_name",length = 50,nullable = false)
	private String receiverName;
	
//	@Column(name="receiver_address",length = 250,nullable = false)
//	private String receiverAddress;
	
	@Column(name="receiver_phone_no",length = 25,nullable = false)
	private String receiverPhoneNo;
	
	@Column(name="receiver_email_id",length = 50,nullable = false)
	private String receiverEmailId;
	
	@Column(name="receiver_house_no",length = 50,nullable = false)
	private String receiverHouseNo;
	
	@Column(name="receiver_street_no",length = 50,nullable = false)
	private String receiverStreetNo;
	
	@Column(name="receiver_city",length = 50,nullable = false)
	private String receiverCity;
	
	@ManyToOne
	@JoinColumn(name="receiver_district_id",referencedColumnName = "district_id",nullable = false)
	private Districts  receiverDistrictId;
	
	@ManyToOne
	@JoinColumn(name="receiver_state_id",referencedColumnName = "state_id",nullable = false)
	private States receiverStateId;
	
	@Column(name="receiver_pincode",length = 10,nullable = false)
	private String  receiverPincode;
	
	@ManyToOne
	@JoinColumn(name="status_id",referencedColumnName = "status_id",nullable = false)
	private Status packagesStatusId;
	
	@Column(name="remarks",length = 500)
	private String  remarks;
	
	@ManyToOne
	@JoinColumn(name="dispatch_by_staff_id",referencedColumnName = "staff_id")
	private StaffMembers dispatchByStaffId;
	
	@ManyToOne
	@JoinColumn(name="sending_branch_id",referencedColumnName = "branch_id",nullable = false)
	private Branches sendingBranchId;
	
	@ManyToOne
	@JoinColumn(name="receiving_branch_id",referencedColumnName = "branch_id",nullable = false)
	private Branches receivingBranchId;

	@OneToMany(mappedBy = "itemsPackageId")
	private List<Items> itemsPackageId;
	
	@OneToMany(mappedBy = "mapPackageId")
	private List<PackagesStatus> mapPackageId;
	
	
}
