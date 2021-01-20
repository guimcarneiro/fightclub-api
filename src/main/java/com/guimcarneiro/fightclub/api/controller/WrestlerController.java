package com.guimcarneiro.fightclub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimcarneiro.fightclub.api.model.CreateWrestlerModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowWrestlerModel;
import com.guimcarneiro.fightclub.api.model.UpdateWrestlerModel;
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
	
	@GetMapping
	public ResponseEntity<List<DefaultShowWrestlerModel>> listAll() {
		return this.wrestlerApiService.listAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DefaultShowWrestlerModel> findById(@PathVariable Long id) {
		return this.wrestlerApiService.find(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateWrestlerModel uwm){
		return this.wrestlerApiService.update(id, uwm);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return this.wrestlerApiService.delete(id);
	}
	
}
