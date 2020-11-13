package se.iths.rest;

import se.iths.entity.Item;
import se.iths.entity.User;
import se.iths.service.UserService;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {

    @Inject
    UserService userService;


    @Path("new")
    @POST
    public Response createUser(User user) {
        try {
            userService.createUser(user);
            return Response.ok(user).build();
        } catch (JsonParsingException j) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("update")
    @PUT
    public Response updateUser(User user) {
        try {
            userService.updateUser(user);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }





    @Path("getall")
    @GET
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Path("{id}")
    @DELETE
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return Response.ok().entity("User with ID " + id + " was successfully deleted.").build();
    }

}
