package com.cms.dda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="designation",uniqueConstraints = {@UniqueConstraint(name="designation_name_uk",columnNames = {"designation_name"})})
@Getter
@Setter
public class Designation {
	
	@Id
	@Column(name="designation_id")
	@GeneratedValue(generator = "designation_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1,name = "designation_gen",sequenceName = "designation_seq")
	private int designationId;
	
	@Column(name="designation_name",length = 50,nullable = false)
	private String designationName;
	
	@OneToMany(mappedBy = "designationId")
	private List<StaffMembers> designationIds;
	
}
