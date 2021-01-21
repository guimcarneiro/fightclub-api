package com.guimcarneiro.fightclub.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.api.mapper.FightMapper;
import com.guimcarneiro.fightclub.api.model.CreateFightModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowFightModel;
import com.guimcarneiro.fightclub.domain.model.Fight;
import com.guimcarneiro.fightclub.domain.model.Wrestler;
import com.guimcarneiro.fightclub.domain.repository.WrestlerRepository;
import com.guimcarneiro.fightclub.domain.service.FightService;

@Service
public class FightApiService {

	@Autowired
	private FightService fightService;
	
	@Autowired
	private WrestlerRepository wrestlerRepository;
	
	public ResponseEntity<DefaultShowFightModel> fight(CreateFightModel cfm) {
		Optional<Wrestler> optWrestler1Db = this.wrestlerRepository.findById(cfm.getWrestler1());
		Optional<Wrestler> optWrestler2Db = this.wrestlerRepository.findById(cfm.getWrestler2());
		
		if(optWrestler1Db.isEmpty() || optWrestler2Db.isEmpty()) {
			throw new RuntimeException("One of the wrestlers doesn't exist on database");
		}
		
		Wrestler wrestler1Db = optWrestler1Db.get();
		Wrestler wrestler2Db = optWrestler2Db.get();
		
		Fight fightDb = this.fightService.fight(wrestler1Db, wrestler2Db);
		
		DefaultShowFightModel fightDoneModel = new DefaultShowFightModel();
		FightMapper.mapFightToDefaultShowFightModel(fightDb, fightDoneModel);
		
		return new ResponseEntity<>(fightDoneModel, HttpStatus.CREATED);
	}
	
}
