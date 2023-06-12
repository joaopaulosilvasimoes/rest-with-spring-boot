package br.com.joao.simoes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.joao.simoes.controller.PersonController;
import br.com.joao.simoes.data.vo.v1.PersonVO;
import br.com.joao.simoes.exceptions.ResourceNotFoundException;
import br.com.joao.simoes.mapper.DozerMapper;
import br.com.joao.simoes.model.Person;
import br.com.joao.simoes.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository personRepository;

	public List<PersonVO> findAll() {
		
		logger.info("Finding all People!");
		
		var listPersonVO = DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
		
		listPersonVO.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		
		return listPersonVO;
		
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("Finding one Person!");
		
		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		
		return vo;
		
	}
	
	public PersonVO createPerson(PersonVO person) {
		
		logger.info("Creating one Person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo     = DozerMapper.parseObject(personRepository.save(entity),PersonVO.class); 
		
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
		
	}
	
	public PersonVO updatePerson(PersonVO person) {
		
		logger.info("Updating one Person!");
		
		var entity = personRepository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo     = DozerMapper.parseObject(personRepository.save(entity),PersonVO.class); 
		
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
		
	}
	
	public void deletePerson(Long id) {
		
		logger.info("Deleting one Person!");
		
		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		personRepository.delete(entity);
		
	}
	
}
