package com.jsilv.quarkus.testcontainersdynamodb.domain.repository.impl;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import com.jsilv.quarkus.testcontainersdynamodb.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;


    @Override
    public Product findById(String id) {

        Key key = Key.builder()
                .partitionValue(String.valueOf(id))
                .build();

        return this.getTable()
                .getItem(r -> r.key(key));

    }

    @Override
    public Product save(Product item) {

        return this.getTable()
                .putItemWithResponse(PutItemEnhancedRequest.builder(Product.class)
                        .item(item)
                        .build())
                        .attributes();
    }

    @Override
    public Product delete(Product item) {
        return this.getTable()
                .deleteItem(item);
    }

    private DynamoDbTable<Product> getTable() {
        return dynamoDbEnhancedClient.table("app-table", TableSchema.fromBean(Product.class));
    }
}
