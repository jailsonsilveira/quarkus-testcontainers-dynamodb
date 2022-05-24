package com.jsilv.quarkus.testcontainersdynamodb.domain.repository;

import javax.validation.Valid;

public interface CrudRepository<T> {

    T findById(String id);

    T save(@Valid T item);

    T delete(T item);

}
