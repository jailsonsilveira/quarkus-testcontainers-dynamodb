package com.jsilv.quarkus.testcontainersdynamodb.domain.repository.impl;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;
import com.jsilv.quarkus.testcontainersdynamodb.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @Override
    public Person findById(int id) {
        Key key = Key.builder()
                .partitionValue(String.valueOf(id))
                .build();

        return this.getTable()
                .getItem(key);

    }

    @Override
    public Person save(Person item) {
        this.getTable()
                .putItemWithResponse(PutItemEnhancedRequest.builder(Person.class)
                        .item(item)
                        .build())
                .attributes();
        return item;
    }

    @Override
    public Person delete(Person item) {
        return this.getTable()
                .deleteItem(item);
    }

    private DynamoDbTable<Person> getTable() {
        return dynamoDbEnhancedClient.table("app-table", TableSchema.fromBean(Person.class));
    }
}
