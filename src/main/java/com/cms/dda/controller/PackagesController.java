package com.cms.dda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dda.dto.PackagesDto;
import com.cms.dda.service.PackagesService;

@RestController
@RequestMapping("/packages")
public class PackagesController {
	
	@Autowired
	PackagesService pkSer;
	
	@GetMapping("/all")
	public List<PackagesDto> getStates() {
		return pkSer.findAll();
	}
	
}
