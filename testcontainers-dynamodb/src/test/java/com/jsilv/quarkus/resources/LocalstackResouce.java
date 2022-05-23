//package com.jsilv.quarkus.resources;
//
//import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
//import org.testcontainers.dynamodb.DynaliteContainer;
//import org.testcontainers.utility.DockerImageName;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LocalstackResouce implements QuarkusTestResourceLifecycleManager {
//
//
//    private static final DockerImageName DEFAULT_IMAGE_NAME = DockerImageName.parse("quay.io/testcontainers/dynalite:v1.2.1-1");
//    private DynaliteContainer localStack = new DynaliteContainer(DEFAULT_IMAGE_NAME);
//
//    @Override
//    public Map<String, String> start() {
//
//        localStack.start();
//        System.out.println(localStack.getExposedPorts());
//        System.out.println(localStack.getHost());
//        Map<String, String> properties = new HashMap<>();
//
//        properties.put("quarkus.s3.aws.credentials.type", "static");
//        properties.put("quarkus.s3.aws.credentials.static-provider.access-key-id", "accessKey");
//        properties.put("quarkus.s3.aws.credentials.static-provider.secret-access-key", "secretKey");
//        return properties;
//    }
//
//    @Override
//    public void stop() {
//        if(localStack != null){
//            localStack.close();
//        }
//    }
//}
