package com.guimcarneiro.fightclub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimcarneiro.fightclub.api.model.CreateFightModel;
import com.guimcarneiro.fightclub.api.model.ShowFightOnCreateModel;
import com.guimcarneiro.fightclub.api.model.ShowFightOnListModel;
import com.guimcarneiro.fightclub.api.service.FightApiService;

@RestController
@RequestMapping("/fight")
@CrossOrigin
public class FightController {

	@Autowired
	private FightApiService fightApiService;
	
	@PostMapping
	public ResponseEntity<ShowFightOnCreateModel> fight(@RequestBody CreateFightModel cfm){
		return this.fightApiService.fight(cfm);
	}
	
	@GetMapping
	public ResponseEntity<List<ShowFightOnListModel>> listAll() {
		return this.fightApiService.listAll();
	}
	
}
