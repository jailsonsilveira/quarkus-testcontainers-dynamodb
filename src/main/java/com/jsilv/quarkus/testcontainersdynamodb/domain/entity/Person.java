package com.jsilv.quarkus.testcontainersdynamodb.domain.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Getter(onMethod=@__({@DynamoDbPartitionKey}))
    private String id;

    private String name;

    private Integer age;
}
