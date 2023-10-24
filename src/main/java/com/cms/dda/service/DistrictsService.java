package com.cms.dda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dda.dto.DistrictsDto;
import com.cms.dda.repo.DistrictsRepo;


@Service
public class DistrictsService {
	
	private static final Logger log = LoggerFactory.getLogger(DistrictsService.class);

	@Autowired
	private DistrictsRepo districtsRepo;
	
	
	public List<DistrictsDto> findAll() {
		log.info("In DistrictsServiceImpl :: findAllDistrictByStateId");
		return districtsRepo.findAll().stream()
				.map(t->new DistrictsDto(t.getDistrictId(),t.getDistrictName(),t.getStates().getStateId())).collect(Collectors.toList());
	}
	
	public List<DistrictsDto> findByStateId(Integer stateId) {
		log.info("In DistrictsServiceImpl :: findAllDistrictByStateId");
		return districtsRepo.findByStateId(stateId).stream()
				.map(t->new DistrictsDto(t.getDistrictId(),t.getDistrictName(),stateId)).collect(Collectors.toList());
	}
}
