package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.StatesDto;
import com.cms.dda.repo.StatesRepo;


@Service
public class StatesService {
	
	private static final Logger log = LoggerFactory.getLogger(StatesService.class);

	@Autowired
	private StatesRepo statesRepo;
	
	
	public List<StatesDto> findAll() {
		log.info("In StatesService :: findAll");
		return statesRepo.findAll().stream()
				.map(t->new StatesDto(t.getStateId(),t.getStateName())).collect(Collectors.toList());
	}
	
}
