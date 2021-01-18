package com.guimcarneiro.fightclub.api.model;

import java.time.OffsetDateTime;

public class DefaultShowWrestlerModel {

private String name;
	
	private String description;
	
	private String nacionality;
	
	private String avatar;
	
	private Integer height;
	
	private String category;
	
	private Integer numWins;
	
	private Integer numLosses;
	
	private CreateWrestlerSkillModel skill;
	
	private OffsetDateTime createdAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CreateWrestlerSkillModel getSkill() {
		return skill;
	}

	public void setSkill(CreateWrestlerSkillModel skill) {
		this.skill = skill;
	}

	public Integer getNumWins() {
		return numWins;
	}

	public void setNumWins(Integer numWins) {
		this.numWins = numWins;
	}

	public Integer getNumLosses() {
		return numLosses;
	}

	public void setNumLosses(Integer numLosses) {
		this.numLosses = numLosses;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
