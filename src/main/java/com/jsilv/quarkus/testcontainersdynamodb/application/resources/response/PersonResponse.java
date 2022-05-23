package com.jsilv.quarkus.testcontainersdynamodb.application.resources.response;

import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonResponse {

    private String name;
    private String id;
    private Integer age;

    public static PersonResponse fromPerson(Person person){
        return new PersonResponse(
           person.getName(),
           person.getId(),
           person.getAge()
        );
    }
}
