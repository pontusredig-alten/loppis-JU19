package se.iths.rest;

import se.iths.entity.Item;
import se.iths.entity.User;
import se.iths.service.BuyerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("buyer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuyerRest {

    @Inject
    BuyerService buyerService;


    @Path("getusersforitem/{buyerName}/{itemName}")
    @GET
    public Set<User> getSpecificUsersForItem(@PathParam("buyerName") String buyerName, @PathParam("itemName") String itemName) {
        return buyerService.getSpecificUsersForItem(buyerName, itemName);
    }




}
