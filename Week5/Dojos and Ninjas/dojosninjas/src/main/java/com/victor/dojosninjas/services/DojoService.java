package com.victor.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.victor.dojosninjas.models.Dojo;
import com.victor.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository repo; 
	
	public DojoService(DojoRepository repo) {
		this.repo = repo;
	}
	
	public List<Dojo> all() {
		return repo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> result = repo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		else {
			return null;
		}
	}
	
	public Dojo updateDojo(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public void deleteDojo(Long id) {
		Optional<Dojo> result = repo.findById(id);
		if (result.isPresent()) {
			repo.deleteById(id);
		}
	}
	
}
