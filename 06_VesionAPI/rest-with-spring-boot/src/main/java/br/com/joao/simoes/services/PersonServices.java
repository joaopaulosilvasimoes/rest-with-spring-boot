package br.com.joao.simoes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.simoes.data.vo.v1.PersonVO;
import br.com.joao.simoes.data.vo.v2.PersonVOV2;
import br.com.joao.simoes.exceptions.ResourceNotFoundException;
import br.com.joao.simoes.mapper.DozerMapper;
import br.com.joao.simoes.mapper.custom.PersonMapper;
import br.com.joao.simoes.model.Person;
import br.com.joao.simoes.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonMapper personMapper;
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all People!");
		
		return DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
		
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("Finding one Person!");
		
		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
		
	}
	
	public PersonVO createPerson(PersonVO person) {
		
		logger.info("Creating one Person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo     = DozerMapper.parseObject(personRepository.save(entity),PersonVO.class); 
		
		return vo;
		
	}
	
	public PersonVOV2 createPersonV2(PersonVOV2 person) {
		
		logger.info("Creating one Person with V2!");
		
		var entity = personMapper.convertValueObjectToEntity(person);
		var vo     = personMapper.convertEntityToValueObject(personRepository.save(entity)); 
		
		return vo;
		
	}
	
	public PersonVO updatePerson(PersonVO person) {
		
		logger.info("Updating one Person!");
		
		var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo     = DozerMapper.parseObject(personRepository.save(entity),PersonVO.class); 
		
		return vo;
		
	}
	
	public void deletePerson(Long id) {
		
		logger.info("Deleting one Person!");
		
		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		personRepository.delete(entity);
		
	}
	
}
