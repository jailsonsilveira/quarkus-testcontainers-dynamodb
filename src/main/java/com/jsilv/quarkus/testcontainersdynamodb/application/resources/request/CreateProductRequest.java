package com.jsilv.quarkus.testcontainersdynamodb.application.resources.request;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String id;
    private String name;
    private String description;


    public Product toProduct() {
        return Product.builder()
                .id(this.getId())
                .name(this.getName())
                .description(this.getDescription())
                .build();
    }
}
