package se.iths.rest;

import se.iths.entity.Item;
import se.iths.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemRest {


    @Inject
    ItemService itemService;

    @Path("new")
    @POST
    public Response createItem(Item item) {
        itemService.createItem(item);
        return Response.ok(item).build();
    }

    @Path("update")
    @PUT
    public Response updateItem(Item item) {
        itemService.updateItem(item);
        return Response.ok(item).build();
    }

    @Path("{id}")
    @GET
    public Response getItem(@PathParam("id") Long id) {
        Item foundItem = itemService.findItemById(id);
        if (foundItem != null) {
            return Response.ok(foundItem).build();
        } else {
            throw new ItemNotFoundException("Item with ID " + id + " not found.");
        }
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Item foundItem = itemService.findItemById(id);
        if (foundItem != null) {
            itemService.deleteItem(id);
            return Response.ok().entity("Item with ID " + id + " was successfully deleted.").build();
        } else {
            throw new ItemNotFoundException("Item with ID " + id + " not found.");
        }
    }




    @Path("getall")
    @GET
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @Path("getbyname_dq/{name}")
    @GET
    public List<Item> getByNameDQ(@PathParam("name") String name) {
        return itemService.getByNameDynamicQuery(name);
    }

    @Path("getbyname_np/{name}")
    @GET
    public List<Item> getByNameNP(@PathParam("name") String name) {
        return itemService.getByNameNamedParameters(name);
    }

    @Path("getbyname_pp/{name}")
    @GET
    public List<Item> getByNamePP(@PathParam("name") String name) {
        return itemService.getByNamePositionalParameters(name);
    }

    @Path("getsorted")
    @GET
    public List<Item> getAllItemsSortedByCategory() {
        return itemService.getAllItemsSortedByCategory();
    }

    @Path("getbyprice/{minPrice}/{maxPrice}")
    @GET
    public List<Item> getByPrice(@PathParam("minPrice") double minPrice, @PathParam("maxPrice") double maxPrice) {
        return itemService.getAllItemsBetweenPrice(minPrice, maxPrice);
    }


}
