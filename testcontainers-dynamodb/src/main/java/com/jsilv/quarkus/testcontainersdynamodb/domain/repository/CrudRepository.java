package com.jsilv.quarkus.testcontainersdynamodb.domain.repository;

public interface CrudRepository<T> {

    T findById(int id);

    T save(T item);

    T delete(T item);

}
