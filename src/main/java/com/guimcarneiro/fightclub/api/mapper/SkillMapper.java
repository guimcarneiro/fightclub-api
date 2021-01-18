package com.guimcarneiro.fightclub.api.mapper;

import com.guimcarneiro.fightclub.api.model.CreateWrestlerSkillModel;
import com.guimcarneiro.fightclub.domain.model.Skill;

public class SkillMapper {

	/**
	 * Map WrestlerSkillModel to Skill. It preserves the skill's id.
	 * 
	 * @param cwsm
	 * @param skill
	 */
	public static void mapCreateWrestlerSkillModelToSkill(CreateWrestlerSkillModel cwsm, Skill skill) {
		skill.setAgility(cwsm.getAgility());
		skill.setEndurance(cwsm.getEndurance());
		skill.setForce(cwsm.getForce());
		skill.setNervousness(cwsm.getNervousness());
		skill.setTechnique(cwsm.getTechnique());
	}
	
	/**
	 * Map Skill to WrestlerSkillModel.
	 * 
	 * @param skill
	 * @param cwsm
	 */
	public static void mapSkillToCreateWrestlerSkillModel(Skill skill, CreateWrestlerSkillModel cwsm) {
		cwsm.setAgility(skill.getAgility());
		cwsm.setEndurance(skill.getEndurance());
		cwsm.setForce(skill.getForce());
		cwsm.setId(skill.getId());
		cwsm.setNervousness(skill.getNervousness());
		cwsm.setTechnique(skill.getTechnique());
	}
	
}
