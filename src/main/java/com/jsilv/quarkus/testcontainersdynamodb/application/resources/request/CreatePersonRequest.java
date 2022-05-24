package com.jsilv.quarkus.testcontainersdynamodb.application.resources.request;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;
import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    private String id;
    private String name;
    private Integer age;

    public Person toPerson(){
        return new Person(
                this.getId(),
                this.getName(),
                this.getAge(),
                List.of(new Product("2", "abc", "description"))
        );
    }
}
