package com.jsilv.quarkus.testcontainersdynamodb.application.resources;

import com.jsilv.quarkus.testcontainersdynamodb.application.resources.request.CreatePersonRequest;
import com.jsilv.quarkus.testcontainersdynamodb.application.resources.response.PersonResponse;
import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;
import com.jsilv.quarkus.testcontainersdynamodb.domain.services.PersonService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/people")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService personService;

    @POST
    public Response createPerson(CreatePersonRequest createPersonRequest) {

        Person person = this.personService.create(createPersonRequest.toPerson());
        return Response.ok(PersonResponse.fromPerson(person))
                .build();
    }

    @GET
    @Path("{idPerson}")
    public Response getById(@PathParam("idPerson") String idPerson) {
        return Response.ok(
                        PersonResponse.fromPerson(
                                this.personService.findById(idPerson)
                        )
                )
                .build();
    }

}
