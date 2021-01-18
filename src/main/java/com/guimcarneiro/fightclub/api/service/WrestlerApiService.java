package com.guimcarneiro.fightclub.api.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.api.mapper.SkillMapper;
import com.guimcarneiro.fightclub.api.mapper.WrestlerMapper;
import com.guimcarneiro.fightclub.api.model.CreateWrestlerModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowWrestlerModel;
import com.guimcarneiro.fightclub.domain.model.Category;
import com.guimcarneiro.fightclub.domain.model.Skill;
import com.guimcarneiro.fightclub.domain.model.Wrestler;
import com.guimcarneiro.fightclub.domain.repository.CategoryRepository;
import com.guimcarneiro.fightclub.domain.repository.WrestlerRepository;
import com.guimcarneiro.fightclub.domain.service.WrestlerService;

@Service
public class WrestlerApiService {
	
	//FIXME: implements a ApiService interface, maybe?
	
	@Autowired
	private WrestlerService wrestlerService;
	
	@Autowired
	private WrestlerRepository wrestlerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ResponseEntity<List<DefaultShowWrestlerModel>> listAll() {
		
		List<Wrestler> wrestlers = wrestlerRepository.findAll();
		List<DefaultShowWrestlerModel> defaultShowWrestlerModels = new ArrayList<>();
		
		for (Wrestler wrestler : wrestlers) {
			DefaultShowWrestlerModel dswm = new DefaultShowWrestlerModel();
			WrestlerMapper.mapWrestlerToDefaultShowWrestlerModel(wrestler, dswm);
			defaultShowWrestlerModels.add(dswm);
		}
		
		return ResponseEntity.ok(defaultShowWrestlerModels);
	}
	
	public ResponseEntity<DefaultShowWrestlerModel> save(CreateWrestlerModel cwm) {
			Wrestler newWrestler = new Wrestler();
			WrestlerMapper.mapCreateWrestlerModelToWrestler(cwm, newWrestler);
			
			Skill skill = new Skill();
			SkillMapper.mapCreateWrestlerSkillModelToSkill(cwm.getSkill(), skill);
			newWrestler.setSkill(skill);
			
			//TODO: busca pela categoria. Se não existir lançar erro.
			
			Optional<Category> optCategoryDb = this.categoryRepository.findById(cwm.getCategory());
			if(optCategoryDb.isEmpty()) {
				//FIXME: lançar erro de maneira correta, com DTO criado especificamente para isso.
				throw new RuntimeException("There is no such category");
			}
			
			Category categoryDb = optCategoryDb.get();
			
			newWrestler.setCategory(categoryDb);
			newWrestler.setCreatedAt(OffsetDateTime.now());
			
			Wrestler savedWrestler = this.wrestlerRepository.save(newWrestler);
			
			DefaultShowWrestlerModel savedWrestlerModel = new DefaultShowWrestlerModel();
			WrestlerMapper.mapWrestlerToDefaultShowWrestlerModel(savedWrestler, savedWrestlerModel);
			
			return ResponseEntity.ok(savedWrestlerModel);
	}
	
}
