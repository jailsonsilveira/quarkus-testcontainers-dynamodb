package com.jsilv.quarkus.testcontainersdynamodb.domain.services;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;

public interface PersonService {

    Person findById(String id);

    Person create(Person person);

    Person update(int id, Person person);

    Person delete(int id, Person person);
}
