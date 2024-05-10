package rest;

import rest.dao.CarnetDao;
import rest.dao.CarnetDaoImpl;
import rest.models.Carnet;

import java.util.List;

import jakarta.ws.rs.PathParam; // Correct import for PathParam
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/carnet")
public class CarnetResource {
    private CarnetDao carnetDao = new CarnetDaoImpl();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carnet getCarnet(@PathParam("id") int id) {
        return carnetDao.findById(id);
    }

    @DELETE
    @Path("/delete/{nomPersonne}")
    public void deleteContact(@PathParam("nomPersonne") String nomPersonne) {
        carnetDao.deleteContact(nomPersonne);
    }

    @DELETE
    @Path("/deleteAll")
    public void deleteAllContacts() {
        carnetDao.deleteAllContacts();
    }
}