package br.com.joao.simoes.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.joao.simoes.data.vo.v2.PersonVOV2;
import br.com.joao.simoes.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToValueObject(Person person) {
		
		PersonVOV2 valueObject = new PersonVOV2();
		
		valueObject.setId(person.getId());
		valueObject.setFirstName(person.getFirstName());
		valueObject.setLastName(person.getLastName());
		valueObject.setAddress(person.getAddress());
		valueObject.setGender(person.getGender());
		valueObject.setBirthDay(new Date());
		
		return valueObject;
		
	}
	
	public Person convertValueObjectToEntity(PersonVOV2 valueObject) {
		
		Person entity = new Person();
		
		entity.setId(valueObject.getId());
		entity.setFirstName(valueObject.getFirstName());
		entity.setLastName(valueObject.getLastName());
		entity.setAddress(valueObject.getAddress());
		entity.setGender(valueObject.getGender());
		//entity.setBirthDay(new Date());
		
		return entity;
		
	}
	
}
