package com.guimcarneiro.fightclub.api.mapper;

import com.guimcarneiro.fightclub.api.model.CreateWrestlerModel;
import com.guimcarneiro.fightclub.domain.model.Wrestler;

public class WrestlerMapper {

	/**
	 * It maps CreateWrestlerModel to Wrestler. It preserves the id from Wrestler.
	 * Category and Skill must be set "outside".
	 * 
	 * @param cwm
	 * @param wrestler
	 */
	public static void mapCreateWrestlerModelToWrestler(CreateWrestlerModel cwm, Wrestler wrestler) {
		wrestler.setAvatar(cwm.getAvatar());
		wrestler.setDescription(cwm.getDescription());
		wrestler.setHeight(cwm.getHeight());
		wrestler.setNacionality(cwm.getNacionality());
		wrestler.setName(cwm.getName());
	}
	
	/**
	 * It maps Wrestler to CreateWrestlerModel.
	 * 
	 * @param wrestler
	 * @param cwm
	 */
	public static void mapWrestlerToCreateWrestlerModel(Wrestler wrestler, CreateWrestlerModel cwm) {
		cwm.setId(wrestler.getId());
		cwm.setAvatar(wrestler.getAvatar());
		cwm.setCategory(wrestler.getCategory().getName());
		cwm.setDescription(wrestler.getDescription());
		cwm.setHeight(wrestler.getHeight());
		cwm.setNacionality(wrestler.getNacionality());
		cwm.setName(wrestler.getName());
	}
	
}
