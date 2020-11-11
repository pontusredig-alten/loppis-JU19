package se.iths.rest;

import se.iths.entity.Item;
import se.iths.entity.User;
import se.iths.service.UserService;

import javax.inject.Inject;
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

        userService.createUser(user);
        return Response.ok(user).build();
    }

    @Path("getall")
    @GET
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
