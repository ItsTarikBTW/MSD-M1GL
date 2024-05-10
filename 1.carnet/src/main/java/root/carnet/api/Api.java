package root.carnet.api;

import jakarta.ws.rs.*;
import root.carnet.Model.Carnet;
import root.carnet.Model.Adress;

@Path("/v1")
public class Api {

    @GET
    @Path("/carnet")
    @Produces("application/json")
    public Carnet getCarnet() {
        return new Carnet("Test");
    }
}