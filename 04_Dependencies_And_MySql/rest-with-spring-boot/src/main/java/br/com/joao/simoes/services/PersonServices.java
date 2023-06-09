package br.com.joao.simoes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.simoes.exceptions.ResourceNotFoundException;
import br.com.joao.simoes.model.Person;
import br.com.joao.simoes.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository personRepository;

	public List<Person> findAll() {
		
		logger.info("Finding all People!");
		
		return personRepository.findAll();
		
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one Person!");
		
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
	}
	
	public Person createPerson(Person person) {
		
		logger.info("Creating one Person!");
		
		return personRepository.save(person);
		
	}
	
	public Person updatePerson(Person person) {
		
		logger.info("Updating one Person!");
		
		Person entity = findById(person.getId()); 
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return personRepository.save(entity);
		
	}
	
	public void deletePerson(Long id) {
		
		logger.info("Deleting one Person!");
		
		Person entity = findById(id); 
		
		personRepository.delete(entity);
		
	}
	
	@SuppressWarnings("unused")
	private Person mockPerson(Long id) {
		
		Person person = new Person();
		
		person.setId(id);
		person.setFirstName("Person name - " + id);
		person.setLastName("Last Name - " + id);
		person.setAddress("Some address in some country - " + id);
		person.setGender((id % 2 == 0) ? "Female" : "Male");
		
		return person;
		
	}
	
}
