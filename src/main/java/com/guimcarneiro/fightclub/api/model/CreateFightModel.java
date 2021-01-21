package com.guimcarneiro.fightclub.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateFightModel {

	@JsonProperty("wrestler_1")
	private Long wrestler1;
	
	@JsonProperty("wrestler_2")
	private Long wrestler2;

	public Long getWrestler1() {
		return wrestler1;
	}

	public void setWrestler1(Long wrestler1) {
		this.wrestler1 = wrestler1;
	}

	public Long getWrestler2() {
		return wrestler2;
	}

	public void setWrestler2(Long wrestler2) {
		this.wrestler2 = wrestler2;
	}
	
}
