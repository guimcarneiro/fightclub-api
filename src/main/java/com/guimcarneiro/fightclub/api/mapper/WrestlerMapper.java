package com.guimcarneiro.fightclub.api.mapper;

import com.guimcarneiro.fightclub.api.model.CreateWrestlerModel;
import com.guimcarneiro.fightclub.api.model.CreateWrestlerSkillModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowWrestlerModel;
import com.guimcarneiro.fightclub.domain.model.Wrestler;

public class WrestlerMapper {

	/**
	 * It maps CreateWrestlerModel to Wrestler. It preserves the id from Wrestler.
	 * Category, Skill createdAt and avatar must be set "outside".
	 * 
	 * @param cwm
	 * @param wrestler
	 */
	public static void mapCreateWrestlerModelToWrestler(CreateWrestlerModel cwm, Wrestler wrestler) {
		wrestler.setDescription(cwm.getDescription());
		wrestler.setHeight(cwm.getHeight());
		wrestler.setNacionality(cwm.getNacionality());
		wrestler.setName(cwm.getName());
	}
	
	/**
	 * It maps Wrestler to CreateWrestlerModel. It must set avatar.
	 * 
	 * @param wrestler
	 * @param cwm
	 */
	public static void mapWrestlerToCreateWrestlerModel(Wrestler wrestler, CreateWrestlerModel cwm) {
		cwm.setId(wrestler.getId());
		
		cwm.setCategory(wrestler.getCategory().getName());
		cwm.setDescription(wrestler.getDescription());
		cwm.setHeight(wrestler.getHeight());
		cwm.setNacionality(wrestler.getNacionality());
		cwm.setName(wrestler.getName());
	}
	
	/**
	 * It maps Wrestler to DefaultShowWrestlerModel. It doesnt set avatar.
	 * 
	 * @param wrestler
	 * @param dswm
	 */
	public static void mapWrestlerToDefaultShowWrestlerModel(Wrestler wrestler, DefaultShowWrestlerModel dswm) {
		dswm.setCategory(wrestler.getCategory().getName());
		dswm.setCreatedAt(wrestler.getCreatedAt());
		dswm.setDescription(wrestler.getDescription());
		dswm.setHeight(wrestler.getHeight());
		dswm.setNacionality(wrestler.getNacionality());
		dswm.setName(wrestler.getName());
		dswm.setNumLosses(wrestler.getNumLosses());
		dswm.setNumWins(wrestler.getNumWins());
		
		CreateWrestlerSkillModel cwsm = new CreateWrestlerSkillModel();
		SkillMapper.mapSkillToCreateWrestlerSkillModel(wrestler.getSkill(), cwsm);
		
		dswm.setSkill(cwsm);
	}
	
}
