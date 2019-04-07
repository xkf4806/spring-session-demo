package com.example.goopal.repository;

import com.example.goopal.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author xinj.x
 */
public interface PersonRepository extends CrudRepository<Person, String> {
}
