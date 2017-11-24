package restservice.controllers;

import restservice.entities.UserAccount;
import restservice.exceptions.AccountAlreadyExistsException;
import restservice.exceptions.AccountNotExistsException;
import restservice.services.UserAccountService;
import restservice.services.UserAccountServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/api/v1/users")
public class UserAccountController {

    private UserAccountService service = new UserAccountServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(service.getAccounts()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{login}")
    public Response getUserByLogin(@PathParam(value = "login") String login) {
        try {
            UserAccount userAccount = service.getAccountByLogin(login);
            return Response.ok(userAccount).build();
        } catch (AccountNotExistsException e) {
            return Response.status(404).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAccount(UserAccount userAccount) {
        try {
            userAccount = service.addAccount(userAccount);
            return Response.ok(userAccount).build();
        } catch (AccountAlreadyExistsException e) {
            return Response.status(409).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{login}")
    public Response updateAccount(@PathParam("login") String login,
                                  UserAccount userAccount) {
        try {
            userAccount = service.updateAccount(userAccount);
            return Response.ok(userAccount).build();
        } catch (AccountNotExistsException e) {
            return Response.status(404).build();
        }
    }
}
