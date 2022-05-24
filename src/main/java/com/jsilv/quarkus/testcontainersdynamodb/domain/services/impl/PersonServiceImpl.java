package com.jsilv.quarkus.testcontainersdynamodb.domain.services.impl;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;
import com.jsilv.quarkus.testcontainersdynamodb.domain.repository.PersonRepository;
import com.jsilv.quarkus.testcontainersdynamodb.domain.services.PersonService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    @Override
    public Person findById(int id) {
        return this.personRepository.findById(id);
    }

    @Override
    public Person create(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person update(int id, Person person) {
        return Optional.ofNullable(personRepository.findById(id))
                .map(personRepository::save)
                .orElseThrow(() -> new RuntimeException("Error while updating"));

    }

    @Override
    public Person delete(int id, Person person) {
        return Optional.ofNullable(personRepository.findById(id))
                .map(personRepository::delete)
                .orElseThrow(() -> new RuntimeException("Error while deleting"));
    }
}
