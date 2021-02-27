package com.guimcarneiro.fightclub.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.domain.exception.BusinessException;
import com.guimcarneiro.fightclub.domain.model.Fight;
import com.guimcarneiro.fightclub.domain.model.Skill;
import com.guimcarneiro.fightclub.domain.model.Wrestler;
import com.guimcarneiro.fightclub.domain.repository.FightRepository;
import com.guimcarneiro.fightclub.domain.repository.WrestlerRepository;

@Service
public class FightService {

	@Autowired
	private WrestlerRepository wrestlerRepository;
	
	@Autowired
	private FightRepository fightRepository;
	
	@Transactional
	public Fight fight(Wrestler wrestler1, Wrestler wrestler2) {
		if(!wrestler1.getCategory().equals(wrestler2.getCategory())) {
			throw new BusinessException("Wrestlers must be from the same category");
		}
		
		FightResult fightResult = getFightResult(wrestler1, wrestler2);
		Wrestler winner = fightResult.getWinner();
		Wrestler loser = fightResult.getLoser();
		
		
		Fight newFight = new Fight();
		newFight.setCategory(wrestler1.getCategory());
		newFight.setHappenedAt(OffsetDateTime.now());
		newFight.setWinner(winner);
		newFight.setLoser(loser);
		
		Fight fightDb = this.fightRepository.save(newFight);
		
		winner.setNumWins(winner.getNumWins() + 1);
		loser.setNumLosses(loser.getNumLosses() + 1);
		
		this.wrestlerRepository.save(winner);
		this.wrestlerRepository.save(loser);
		
		return fightDb;
	}
	
	private FightResult getFightResult(Wrestler wrestler1, Wrestler wrestler2) {
		Skill skill1 = wrestler1.getSkill();
		Skill skill2 = wrestler2.getSkill();
		
		//TEMPORARY - The decider is who has more force.
		FightResult fightResult = null;
		if(skill1.getForce() > skill2.getForce()) {
			fightResult = new FightResult(wrestler1, wrestler2);
		} else {
			fightResult = new FightResult(wrestler2, wrestler1);
		}
		
		return fightResult;
	}
	
	private class FightResult {
		private Wrestler winner;
		private Wrestler loser;
		
		private FightResult(Wrestler winner, Wrestler loser) {
			this.winner = winner;
			this.loser = loser;
		}
		
		public Wrestler getWinner() {
			return this.winner;
		}
		
		public Wrestler getLoser() {
			return this.loser;
		}
		
	}
	
}
