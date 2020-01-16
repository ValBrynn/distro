package business.controller;

import business.service.TestService;
import business.model.TestModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/test")
public class TestController {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(TestModel user) {
        if(user == null) return Response.status(400).build();
        if(TestService.add(user)) return Response.status(201).build();
        return Response.status(400).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TestModel get(@PathParam("id") int id) {
        if(id <= 0) return null;
        TestModel result = TestService.get(id);
        return result;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TestModel> getAll() {
        List<TestModel> result = TestService.getAll();
        return result;
    }

}