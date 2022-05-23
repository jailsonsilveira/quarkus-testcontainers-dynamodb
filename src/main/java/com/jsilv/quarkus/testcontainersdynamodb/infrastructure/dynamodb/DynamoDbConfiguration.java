package com.jsilv.quarkus.testcontainersdynamodb.infrastructure.dynamodb;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.inject.Singleton;
import javax.ws.rs.Produces;
import java.net.URI;

@Singleton
public class DynamoDbConfiguration {

    public DynamoDbClient createDynamoDbClient() {

        StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider
                .create(AwsBasicCredentials.create("dummy", "dummy"));
        Region region = Region.US_EAST_1;
        return DynamoDbClient.builder()
                .credentialsProvider(credentialsProvider)
                .endpointOverride(URI.create("http://localhost:4567"))
                .region(region)
                .build();
    }

    @Singleton
    @Produces
    public DynamoDbEnhancedClient createDynamoDbEnchancedClient() {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(createDynamoDbClient())
                .build();
    }
}
