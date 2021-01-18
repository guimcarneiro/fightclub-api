package com.guimcarneiro.fightclub.api.model;

public class CreateWrestlerModel {

	private Long id;
	
	private String name;
	
	private String description;
	
	private String nacionality;
	
	private String avatar;
	
	private Integer height;
	
	private String category;
	
	private CreateWrestlerSkillModel skill;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
