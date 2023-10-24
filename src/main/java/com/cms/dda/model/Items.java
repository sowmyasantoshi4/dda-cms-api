package com.cms.dda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="items")
@Getter
@Setter
public class Items{

	@Id
	@GeneratedValue(generator = "items_gen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1,name = "items_gen",sequenceName = "items_seq")
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name",length = 100,nullable = false)
	private String itemName;
	
	@Column(name="height",precision = 15,nullable = false)
	private Double height;
	
	@Column(name="weight",precision = 15,nullable = false)
	private Double weight;
	
	@Column(name="width",precision = 15,nullable = false)
	private Double width;
	
	@Column(name="price",precision = 15,nullable = false)
	private Double price;
	
	@ManyToOne 
	@JoinColumn(name="package_id",nullable = false)
	private Packages itemsPackageId;
}
