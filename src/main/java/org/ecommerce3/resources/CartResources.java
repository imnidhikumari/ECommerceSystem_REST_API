package org.ecommerce3.resources;

import org.ecommerce3.entity.Cart;
import org.ecommerce3.entity.Users;
import org.ecommerce3.services.CartServices;
import org.ecommerce3.services.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResources {
    private final CartServices cartServices;

    public CartResources(CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @POST
    @Path("/register")
    public Response registerUser(Cart cart) {
        Cart addCart = cartServices.addCart(cart);
        return Response.status(Response.Status.CREATED).entity(addCart).build();
    }
}
