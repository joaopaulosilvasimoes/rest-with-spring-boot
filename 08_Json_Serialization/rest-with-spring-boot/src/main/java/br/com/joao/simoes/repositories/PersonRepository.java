package br.com.joao.simoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.simoes.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
		
}
