package com.cms.dda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="packages_status")
@Getter
@Setter
public class PackagesStatus{

	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="package_id",referencedColumnName = "package_id",nullable = false)
	private Packages mapPackageId;
	
	@ManyToOne
	@JoinColumn(name="status_id",referencedColumnName = "status_id",nullable = false)
	private Status mapStatusId;
	
	@CreationTimestamp
	@Column(name="status_updated_on",nullable = false,updatable = false)
	private Date statusUpdatedOn;
	
	@Column(name="remarks")
	private String remarks;
	
}
