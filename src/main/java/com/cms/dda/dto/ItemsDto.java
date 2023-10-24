package com.cms.dda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDto{

	private int itemId;
	
	private String itemName;
	
	private Double height;
	
	private Double weight;
	
	private Double width;
	
	private Double price;
	
	private int packageId;
}
