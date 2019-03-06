/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.afpa.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.formation.business.ServiceSpecie;
import fr.afpa.formation.exceptions.NoObjectEntityException;
import fr.afpa.formation.persistence.Specie;

@RestController
@RequestMapping("/rest/species")
class SpecieController {
	
    @Autowired
    private ServiceSpecie service;

    @GetMapping("")
    public List<Specie> list() {
    	List<Specie> list = service.list();
        return list;
    }
    @GetMapping("/{id}")
    public Specie get(@PathVariable("id") long id) {
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Specie sp,@PathVariable("id") long id) {
    	try {
    		service.findById(id);
    	} catch (Exception ex) {
    		throw new NoObjectEntityException();
    	}
    	sp.setId(id);
    	service.save(sp);
    }
    @PostMapping("")
    public long create(@RequestBody Specie sp) {
    	service.save(sp);
    	return sp.getId();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
    	try {
    		service.findById(id);
    	} catch (Exception ex) {
    		throw new NoObjectEntityException();
    	}
    	service.deleteById(id);
    }
}
