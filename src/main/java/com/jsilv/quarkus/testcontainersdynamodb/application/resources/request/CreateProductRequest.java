package com.jsilv.quarkus.testcontainersdynamodb.application.resources.request;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String id;
    private String sku;
    private String description;


    public Product toProduct() {
        return Product.builder()
                .id(this.getId())
                .sku(this.getSku())
                .description(this.getDescription())
                .build();
    }
}
