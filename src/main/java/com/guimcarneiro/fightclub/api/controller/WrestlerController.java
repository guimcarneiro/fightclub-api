package com.guimcarneiro.fightclub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimcarneiro.fightclub.api.model.CreateWrestlerModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowWrestlerModel;
import com.guimcarneiro.fightclub.api.service.WrestlerApiService;

@RestController
@RequestMapping("/wrestler")
@CrossOrigin
public class WrestlerController {
	
	@Autowired
	private WrestlerApiService wrestlerApiService;
	
	@PostMapping
	public ResponseEntity<DefaultShowWrestlerModel> create(@RequestBody CreateWrestlerModel cwm) {
		return this.wrestlerApiService.save(cwm);
	}
	
	//TODO: find by id
	//TODO: update
	//TODO: delete
	//TODO: list All
	
}
