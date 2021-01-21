package com.guimcarneiro.fightclub.api.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultShowFightModel {

	private Long id;
	
	@JsonProperty("winner_id")
	private Long winner;
	
	@JsonProperty("loser_id")
	private Long loser;
	
	@JsonProperty("happened_at")
	private OffsetDateTime happenedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWinner() {
		return winner;
	}

	public void setWinner(Long winner) {
		this.winner = winner;
	}

	public Long getLoser() {
		return loser;
	}

	public void setLoser(Long loser) {
		this.loser = loser;
	}

	public OffsetDateTime getHappenedAt() {
		return happenedAt;
	}

	public void setHappenedAt(OffsetDateTime happenedAt) {
		this.happenedAt = happenedAt;
	}
	
}
