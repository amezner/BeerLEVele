/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import javax.security.auth.login.LoginException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dnovak
 */
@Provider
public class LoginExceptionMapper implements ExceptionMapper<LoginException> {

    public static class Error {

<<<<<<< HEAD
=======
        public String cause;
        public String message;
    }

>>>>>>> e7551925c391ee9a7ed35eff50911bf62eb11eb8
    @Override
    public Response toResponse(LoginException exception) {
        Error error = new Error();
        error.cause = "login-failure";
        error.message = exception.getMessage();
        return Response.status(Status.BAD_REQUEST).entity(error).build();
    }

}
