package br.com.joao.simoes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.joao.simoes.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		
		logger.info("Finding all People!");
		
		List<Person> persons = new ArrayList<Person>();
		
		for (Long i = 0L; i < 8; i++) {
			
			persons.add(mockPerson(i));
			
		}
		
		return persons;
		
	}
	
	public Person findById(String id) {
		
		logger.info("Finding one Person!");
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("João Paulo");
		person.setLastName("Silva Simões");
		person.setAddress("32013560");
		person.setGender("Male");
		
		return person;
		
	}
	
	public Person createPerson(Person person) {
		
		logger.info("Creating one Person!");
		
		return person;
		
	}
	
	public Person updatePerson(Person person) {
		
		logger.info("Updating one Person!");
		
		return person;
		
	}
	
	public void deletePerson(String id) {
		
		logger.info("Deleting one Person!");
		
	}
	
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
