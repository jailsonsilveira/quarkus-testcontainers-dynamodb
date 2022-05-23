package com.jsilv.quarkus.testcontainersdynamodb.application.resources.response;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import io.quarkus.arc.All;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {

    private String name;
    private String id;
    private String description;

    public static ProductResponse fromProduct(Product product) {

        return new ProductResponse(
                product.getName(),
                product.getId(),
                product.getDescription()
        );
    }
}
