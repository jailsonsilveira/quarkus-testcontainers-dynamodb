package com.jsilv.quarkus.testcontainersdynamodb.domain.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primaryPartitionKey;
import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primarySortKey;

@DynamoDbBean
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private static final TableSchema<Product> TABLE_SCHEMA =
            StaticTableSchema.builder(Product.class)
                    .newItemSupplier(Product::new)
                    .addAttribute(String.class, a -> a.name("id")
                            .getter(Product::getId)
                            .setter(Product::setId)
                            .tags(primaryPartitionKey()))
                    .addAttribute(String.class, a -> a.name("name")
                            .getter(Product::getName)
                            .setter(Product::setName)
                            .tags(primarySortKey()))
                    .addAttribute(String.class, a -> a.name("description")
                            .getter(Product::getDescription)
                            .setter(Product::setDescription))
                    .build();



    @Getter(onMethod=@__({@DynamoDbPartitionKey}))
    private String id;

    private String name;

    private String description;



}
