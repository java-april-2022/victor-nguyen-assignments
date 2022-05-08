package com.victor.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.victor.dojosninjas.models.Ninja;
import com.victor.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	public List<Ninja> all() {
		return repo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return repo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> result = repo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		else {
			return null;
		}
	}
	
	public Ninja updateNinja(Ninja ninja) {
		return repo.save(ninja);
	}
	
	public void deleteNinja(Long id) {
		Optional<Ninja> result = repo.findById(id);
		if (result.isPresent()) {
			repo.deleteById(id);
		}
	}
	
}
