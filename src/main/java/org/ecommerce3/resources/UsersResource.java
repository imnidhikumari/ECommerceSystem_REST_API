package org.ecommerce3.resources;

import org.ecommerce3.entity.Users;
import org.ecommerce3.service.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {
    private final UsersService usersService;

    public UsersResource(UsersService usersService) {
        this.usersService = usersService;
    }

    @POST
    @Path("/register")
    public Response registerUser(Users user) {
        Users createdUser = usersService.registerUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    @GET
    @Path("/{email}")
    public Response getUserByEmail(@PathParam("email") String email) {
        return usersService.getUserByEmail(email)
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @DELETE
    @Path("/delete/{email}")
    public Response deleteUser(@PathParam("email") String email) {
        boolean isDeleted = usersService.deleteUser(email);
        if (isDeleted) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
