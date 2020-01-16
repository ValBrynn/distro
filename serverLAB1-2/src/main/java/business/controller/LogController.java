package business.controller;

import business.model.LogModel;
import business.service.LogService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.List;

@Path("/log")
public class LogController {


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(LogModel log ) throws ParseException {
        if(log == null) return Response.status(400).build();
        if(LogService.add(log)) return Response.status(201).build();
        return Response.status(400).build();
    }

    @GET
    @Path("/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LogModel> getAll(@PathParam("userName" )String user) {

        List<LogModel> result = null;
        result = LogService.getAll(user);
        return result;

    }



    @GET
    @Path("/{userName}/{findUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LogModel> getLogList(@PathParam("userName") String name,@PathParam("findUser") String findUser) {
        List<LogModel> result = null;
        result = LogService.getAll(findUser);
        return result;
    }





}
