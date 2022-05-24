package com.jsilv.quarkus.testcontainersdynamodb.domain.services.impl;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import com.jsilv.quarkus.testcontainersdynamodb.domain.repository.ProductRepository;
import com.jsilv.quarkus.testcontainersdynamodb.domain.services.ProductService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findById(String id)  {
        return this.productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return Optional.ofNullable(productRepository.findById(String.valueOf(id)))
                .map(productRepository::save)
                .orElseThrow(() -> new RuntimeException("Error while updating"));
    }

    @Override
    public Product delete(int id, Product product) {
        return Optional.ofNullable(productRepository.findById(String.valueOf(id)))
                .map(productRepository::delete)
                .orElseThrow(() -> new RuntimeException("Error while deleting"));
    }
}

