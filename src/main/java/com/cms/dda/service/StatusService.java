package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.StatusDto;
import com.cms.dda.repo.StatusRepo;


@Service
public class StatusService {
	
	private static final Logger log = LoggerFactory.getLogger(StatusService.class);

	@Autowired
	private StatusRepo statusRepo;
	
	
	public List<StatusDto> findAll() {
		log.info("In StatusService :: findAll");
		return statusRepo.findAll().stream()
				.map(t->new StatusDto(t.getStatusId(),t.getStatusName())).collect(Collectors.toList());
	}
	
}
