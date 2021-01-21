package com.guimcarneiro.fightclub.api.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowFightOnListModel {

	private Long id;
	
	private ShowWrestlerOnFightListModel winner;
	
	private ShowWrestlerOnFightListModel loser;
	
	@JsonProperty("happened_at")
	private OffsetDateTime happenedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShowWrestlerOnFightListModel getWinner() {
		return winner;
	}

	public void setWinner(ShowWrestlerOnFightListModel winner) {
		this.winner = winner;
	}

	public ShowWrestlerOnFightListModel getLoser() {
		return loser;
	}

	public void setLoser(ShowWrestlerOnFightListModel loser) {
		this.loser = loser;
	}

	public OffsetDateTime getHappenedAt() {
		return happenedAt;
	}

	public void setHappenedAt(OffsetDateTime happenedAt) {
		this.happenedAt = happenedAt;
	}
	
}
