package htl.at.endpoints;

import htl.at.model.Customer;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthEndpoint {

    private String user;
    private String pass;

    @GET
    @Path("/{user}/{pass}")
    @Transactional
    public Response login(@PathParam("user") String user, @PathParam("pass") String pass){
        Customer cust = Customer.find("username", user).firstResult();
        if(cust == null || !pass.equalsIgnoreCase(cust.password))return Response.status(Response.Status.FORBIDDEN).build();
        return Response.accepted(cust.id).build();
    }

    @GET
    @Path("/register/{user}/{pass}")
    @Transactional
    public Response register(@PathParam("user") String user, @PathParam("pass") String pass){
        Customer newCust = new Customer();
        newCust.password = pass;
        newCust.username = user;
        newCust.credibility = "average";
        Customer.persist(newCust);
        return Response.ok(newCust.id).build();
    }
}
