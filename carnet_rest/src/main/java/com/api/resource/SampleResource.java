package com.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("carnets")
public class SampleResource {

    @GET
    @Produces(TEXT_PLAIN)
    public String message() {
        return "yoo what's up! ";
    }

}