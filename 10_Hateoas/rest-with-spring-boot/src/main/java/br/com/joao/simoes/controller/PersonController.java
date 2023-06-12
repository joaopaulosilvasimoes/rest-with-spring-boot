package br.com.joao.simoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.simoes.data.vo.v1.PersonVO;
import br.com.joao.simoes.services.PersonServices;

@RestController
@RequestMapping(path="/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;

	@GetMapping(
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
	public List<PersonVO> findAll() {
		
		System.out.println("findAll");
		
		return personServices.findAll();
		
	}
	
	@GetMapping(path="/{id}", 
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		
		System.out.println("findById");
		
		return personServices.findById(id);
		
	}
	
	@PostMapping(
				 consumes = MediaType.APPLICATION_JSON_VALUE, 
				 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
		
		return personServices.createPerson(person);
		
	}
	
	@PutMapping(
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		
		return personServices.updatePerson(person);
		
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		
		personServices.deletePerson(id);
		
		return ResponseEntity.noContent().build();
		
	}
		
}
