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
@Table(name="status",uniqueConstraints = {@UniqueConstraint(name="status_name_uk",columnNames = {"status_name"})})
@Getter
@Setter
public class Status{
	
	@Id
	@Column(name="status_id")
	private int statusId;
	
	@Column(name="status_name",length = 40,nullable = false)
	private String statusName;
	
	@OneToMany(mappedBy = "packagesStatusId")
	private List<Packages> packagesStatusId;
	
	@OneToMany(mappedBy = "mapStatusId")
	private List<PackagesStatus> mapStatusId;
	
}
