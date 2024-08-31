package com.cms.dda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.DesignationDto;
import com.cms.dda.model.Designation;
import com.cms.dda.repo.DesignationRepo;


@Service
public class DesignationService {
	
	private static final Logger log = LoggerFactory.getLogger(DesignationService.class);

	@Autowired
	private DesignationRepo desigRepo;
	
	
	public List<DesignationDto> findAll() {
		log.info("In StatusService :: findAll");
		return desigRepo.findAll().stream()
				.map(t->new DesignationDto(t.getDesignationId(),t.getDesignationName())).collect(Collectors.toList());
	}
	
	public Optional<Designation> findByOneDesigId(int desigId){
		return desigRepo.findById(desigId);
	}
	
}
