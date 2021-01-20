package com.guimcarneiro.fightclub.api.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.api.mapper.SkillMapper;
import com.guimcarneiro.fightclub.api.mapper.WrestlerMapper;
import com.guimcarneiro.fightclub.api.model.CreateWrestlerModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowWrestlerModel;
import com.guimcarneiro.fightclub.api.model.UpdateWrestlerModel;
import com.guimcarneiro.fightclub.domain.model.Category;
import com.guimcarneiro.fightclub.domain.model.Skill;
import com.guimcarneiro.fightclub.domain.model.Wrestler;
import com.guimcarneiro.fightclub.domain.repository.CategoryRepository;
import com.guimcarneiro.fightclub.domain.repository.SkillRepository;
import com.guimcarneiro.fightclub.domain.repository.WrestlerRepository;
import com.guimcarneiro.fightclub.utils.CommonUtils;

@Service
public class WrestlerApiService {
	
	//FIXME: implements a ApiService interface, maybe?
	
	@Autowired
	private WrestlerRepository wrestlerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	public ResponseEntity<List<DefaultShowWrestlerModel>> listAll() {
		
		List<Wrestler> wrestlers = wrestlerRepository.findAll();
		List<DefaultShowWrestlerModel> defaultShowWrestlerModels = new ArrayList<>();
		
		for (Wrestler wrestler : wrestlers) {
			DefaultShowWrestlerModel dswm = new DefaultShowWrestlerModel();
			WrestlerMapper.mapWrestlerToDefaultShowWrestlerModel(wrestler, dswm);
			
			//check if wrestler has avatar
			if(wrestler.getAvatar() != null) {				
				String b64Avatar = CommonUtils.convertByteArrayToBase64(wrestler.getAvatar());
				dswm.setAvatar(b64Avatar);
			}
			
			defaultShowWrestlerModels.add(dswm);
		}
		
		return new ResponseEntity<>(defaultShowWrestlerModels, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<DefaultShowWrestlerModel> save(CreateWrestlerModel cwm) {
			Wrestler newWrestler = new Wrestler();
			WrestlerMapper.mapCreateWrestlerModelToWrestler(cwm, newWrestler);
			
			//maps and save skill
			Skill newSkill = new Skill();
			SkillMapper.mapCreateWrestlerSkillModelToSkill(cwm.getSkill(), newSkill);
			
			Skill savedSkill = this.skillRepository.save(newSkill);
			
			newWrestler.setSkill(savedSkill);
			
			Optional<Category> optCategoryDb = this.categoryRepository.findById(cwm.getCategory());
			if(optCategoryDb.isEmpty()) {
				//FIXME: throw custom exception instead
				throw new RuntimeException("There is no such category");
			}
			
			Category categoryDb = optCategoryDb.get();
			
			newWrestler.setCategory(categoryDb);
			
			//check if dto has avatar
			//FIXME: check if it comes in base64 format
			if(cwm.getAvatar() != null) {
				byte[] avatar = CommonUtils.convertBase64ToByteArray(cwm.getAvatar());
				newWrestler.setAvatar(avatar);
			}
			
			newWrestler.setCreatedAt(OffsetDateTime.now());
			
			Wrestler savedWrestler = this.wrestlerRepository.save(newWrestler);
			
			DefaultShowWrestlerModel savedWrestlerModel = new DefaultShowWrestlerModel();
			WrestlerMapper.mapWrestlerToDefaultShowWrestlerModel(savedWrestler, savedWrestlerModel);
			savedWrestlerModel.setAvatar(cwm.getAvatar());
			
			return new ResponseEntity<>(savedWrestlerModel, HttpStatus.CREATED);
	}
	
	public ResponseEntity<DefaultShowWrestlerModel> find(Long id) {
		Optional<Wrestler> optWrestlerDb = this.wrestlerRepository.findById(id);
		
		if(optWrestlerDb.isEmpty()) {
			throw new RuntimeException("Wrestler with id " + id + " not found.");
		}
		
		Wrestler wrestlerDb = optWrestlerDb.get();
		
		DefaultShowWrestlerModel wrestlerModel = new DefaultShowWrestlerModel();
			
		WrestlerMapper.mapWrestlerToDefaultShowWrestlerModel(wrestlerDb, wrestlerModel);
		
		if(wrestlerDb.getAvatar() != null) {
			String base64Avatar = CommonUtils.convertByteArrayToBase64(wrestlerDb.getAvatar());
			wrestlerModel.setAvatar(base64Avatar);
		}
		
		return new ResponseEntity<DefaultShowWrestlerModel>(wrestlerModel, HttpStatus.OK);
	}
	
	public ResponseEntity<?> update(Long id, UpdateWrestlerModel uwm){
		
		Optional<Wrestler> optWrestlerDb = this.wrestlerRepository.findById(id);
		
		if(optWrestlerDb.isEmpty()) {
			throw new RuntimeException("Wrestler with id " + id + " not found.");
		}
		
		Optional<Category> optCategoryDb = this.categoryRepository.findById(uwm.getCategory());
		
		if(optCategoryDb.isEmpty()) {
			throw new RuntimeException("Category " + uwm.getCategory() + " doesn't exist.");
		}
		
		Category categoryDb = optCategoryDb.get();
		Wrestler wrestlerDb = optWrestlerDb.get();
		
		WrestlerMapper.mapUpdateWrestlerModelToWrestler(uwm, wrestlerDb);
		Wrestler wrestlerToUpdate = wrestlerDb;
		
		wrestlerToUpdate.setCategory(categoryDb);
		
		byte[] newAvatar = null;
		if(uwm.getAvatar() != null) {			
			newAvatar = CommonUtils.convertBase64ToByteArray(uwm.getAvatar());
		}
		wrestlerToUpdate.setAvatar(newAvatar);
		
		this.wrestlerRepository.save(wrestlerToUpdate);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<?> delete(Long id) {
		
		Optional<Wrestler> optWrestlerDb = this.wrestlerRepository.findById(id);
		
		if(optWrestlerDb.isEmpty()) {
			throw new RuntimeException("Wrestler with id " + id + " not found.");
		}
		
		this.wrestlerRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
