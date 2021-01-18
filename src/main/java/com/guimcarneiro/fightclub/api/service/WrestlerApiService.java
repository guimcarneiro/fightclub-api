package com.guimcarneiro.fightclub.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.api.model.DefaultShowWrestlerModel;
import com.guimcarneiro.fightclub.domain.repository.WrestlerRepository;
import com.guimcarneiro.fightclub.domain.service.WrestlerService;

@Service
public class WrestlerApiService {

	@Autowired
	private WrestlerService wrestlerService;
	
	@Autowired
	private WrestlerRepository wrestlerRepository;
	
	public ResponseEntity<List<DefaultShowWrestlerModel>> listAll() {
		
	}
	
}
