package br.com.joao.simoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.simoes.model.Person;
import br.com.joao.simoes.services.PersonServices;

@RestController
@RequestMapping(path="/person")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	//private PersonServices personServices = new PersonServices();

	@RequestMapping(path="/", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findById() {
		
		return personServices.findAll();
		
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) {
		
		return personServices.findById(id);
		
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		
		return personServices.createPerson(person);
		
	}
	
	@RequestMapping(path="/", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		
		return personServices.updatePerson(person);
		
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {
		
		personServices.deletePerson(id);
		
	}
		
}
