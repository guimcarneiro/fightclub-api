package com.guimcarneiro.fightclub.api.mapper;

import com.guimcarneiro.fightclub.api.model.ShowFightOnCreateModel;
import com.guimcarneiro.fightclub.api.model.ShowFightOnListModel;
import com.guimcarneiro.fightclub.api.model.ShowWrestlerOnFightListModel;
import com.guimcarneiro.fightclub.domain.model.Fight;

public class FightMapper {

	/**
	 * It maps Fight to DefaultShowFightModel.
	 * 
	 * @param fight
	 * @param dsfm
	 */
	public static void mapFightToDefaultShowFightModel(Fight fight, ShowFightOnCreateModel dsfm) {
		dsfm.setId(fight.getId());
		dsfm.setLoser(fight.getLoser().getId());
		dsfm.setWinner(fight.getWinner().getId());
		dsfm.setHappenedAt(fight.getHappenedAt());
	}
	
	/**
	 * It maps Fight to ShowFightOnListModel.
	 * 
	 * @param fight
	 * @param sfolm
	 */
	public static void mapFightToShowFightOnListModel(Fight fight, ShowFightOnListModel sfolm) {
		sfolm.setId(fight.getId());
		sfolm.setHappenedAt(fight.getHappenedAt());
		
		ShowWrestlerOnFightListModel winnerModel = new ShowWrestlerOnFightListModel();
		WrestlerMapper.mapWrestlerToShowWrestlerOnFightListModel(fight.getWinner(), winnerModel);
		sfolm.setWinner(winnerModel);
		
		ShowWrestlerOnFightListModel loserModel = new ShowWrestlerOnFightListModel();
		WrestlerMapper.mapWrestlerToShowWrestlerOnFightListModel(fight.getLoser(), loserModel);
		sfolm.setLoser(loserModel);
	}
	
}
