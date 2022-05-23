package com.jsilv.quarkus.application.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.Map;

@QuarkusTest
public class ProductResourceTest {


    private static final Map<String, File> FRUITS = Map.of(
            "cherry", testFile("cherry"),
            "pear", testFile("pear"));

    private static File testFile(String name) {
        return new File("./src/test/resources/" + name);
    }

    @Test
    @ParameterizedTest
    @ValueSource()
    public void testHelloEndpoint() {


    }

}