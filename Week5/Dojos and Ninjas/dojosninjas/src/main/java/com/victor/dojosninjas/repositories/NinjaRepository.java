package com.victor.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.victor.dojosninjas.models.Dojo;
import com.victor.dojosninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
		
	List<Ninja> findAllByDojo(Dojo dojo);
	
}
