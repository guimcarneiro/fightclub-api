package com.guimcarneiro.fightclub.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.domain.repository.WrestlerRepository;

@Service
public class WrestlerService {

	@Autowired
	private WrestlerRepository wrestlerRepository;
	
}
