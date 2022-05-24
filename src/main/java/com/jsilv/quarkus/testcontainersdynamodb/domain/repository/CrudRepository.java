package com.jsilv.quarkus.testcontainersdynamodb.domain.repository;

import javax.validation.Valid;

public interface CrudRepository<T> {

    T findById(int id);

    T save(@Valid T item);

    T delete(T item);

}
