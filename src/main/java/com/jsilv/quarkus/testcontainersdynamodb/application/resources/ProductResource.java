package com.jsilv.quarkus.testcontainersdynamodb.application.resources;

import com.jsilv.quarkus.testcontainersdynamodb.application.resources.request.CreatePersonRequest;
import com.jsilv.quarkus.testcontainersdynamodb.application.resources.request.CreateProductRequest;
import com.jsilv.quarkus.testcontainersdynamodb.application.resources.response.PersonResponse;
import com.jsilv.quarkus.testcontainersdynamodb.application.resources.response.ProductResponse;
import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Person;
import com.jsilv.quarkus.testcontainersdynamodb.domain.entity.Product;
import com.jsilv.quarkus.testcontainersdynamodb.domain.services.ProductService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @POST
    public Response createPerson(CreateProductRequest createProductRequest) {

        Product product = this.productService.create(createProductRequest.toProduct());
        return Response.ok(ProductResponse.fromProduct(product))
                .build();
    }

    @GET
    @Path("{idProduct}")
    public Response getById(@PathParam("idProduct") String idProduct) {
        return Response.ok(
                        ProductResponse.fromProduct(
                                this.productService.findById(idProduct)
                        )
                )
                .build();
    }
}