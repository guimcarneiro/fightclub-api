package com.guimcarneiro.fightclub.api.mapper;

import com.guimcarneiro.fightclub.api.model.DefaultShowFightModel;
import com.guimcarneiro.fightclub.domain.model.Fight;

public class FightMapper {

	/**
	 * It maps Fight to DefaultShowFightModel.
	 * 
	 * @param fight
	 * @param dsfm
	 */
	public static void mapFightToDefaultShowFightModel(Fight fight, DefaultShowFightModel dsfm) {
		dsfm.setId(fight.getId());
		dsfm.setLoser(fight.getLoser().getId());
		dsfm.setWinner(fight.getWinner().getId());
		dsfm.setHappenedAt(fight.getHappenedAt());
	}
	
}
