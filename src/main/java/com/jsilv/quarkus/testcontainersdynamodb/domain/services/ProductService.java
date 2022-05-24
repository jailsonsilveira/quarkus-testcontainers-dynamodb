package com.jsilv.quarkus.testcontainersdynamodb.domain.services;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;

public interface ProductService {

    Product findById(String id);

    Product create(Product product);

    Product update(int id, Product product);

    Product delete(int id, Product product);

}
