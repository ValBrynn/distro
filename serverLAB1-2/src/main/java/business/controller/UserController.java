package business.controller;

import business.model.UserModel;
import business.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserController {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(UserModel user ) {
        if(user == null) return Response.status(400).build();
        if(UserService.add(user)) return Response.status(201).build();
        return Response.status(400).build();
    }

    @GET
    @Path("/{userName}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userName") String userName,@PathParam("password") String password ) {
        if(userName == null || password == null) {
            return null;
        }
        UserModel result = UserService.getUser(userName,password);
        if(result==null)
        {
            return Response.status(400).build();
        }
        return Response.status(200).build();
    }

    @GET
    @Path("/{findUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUser(@PathParam("findUser") String findUser) {
        if(findUser == null ) {
            return null;
        }
        boolean result = UserService.findUser(findUser);
        if(result==false)
        {
            return Response.status(400).build();
        }
        return Response.status(200).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> getAll() {
        List<UserModel> result = UserService.getAll();
        return result;
    }

}