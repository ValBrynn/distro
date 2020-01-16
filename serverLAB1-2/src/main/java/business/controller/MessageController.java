package business.controller;

import business.model.LogModel;
import business.model.MessageModel;
import business.service.LogService;
import business.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.List;

@Path("/message")
public class MessageController {
   @GET
    @Path("/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageModel> getReceivedMessages(@PathParam("userName") String name){
        List<MessageModel> result = null;

       result = MessageService.getReceivedMessages(name);
       return result;
    }


    @GET
    @Path("/sentMsg/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageModel> getSentMessages(@PathParam("userName") String name){
        List<MessageModel> result = null;

        result = MessageService.getSentMessages(name);
        return result;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(MessageModel m ) throws ParseException {
        if(m == null) return Response.status(400).build();
        if(MessageService.add(m)) return Response.status(201).build();
        return Response.status(400).build();
    }


}
