/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import Exceptions.AuthorizationFailedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dnovak
 */
@Provider



public class AuthorizationFailedExceptionMapper implements ExceptionMapper<AuthorizationFailedException> {
    public static class Error {

        public String cause;
        public String message;
    }

    @Override

    public Response toResponse(AuthorizationFailedException e) {
        LoginExceptionMapper.Error error = new LoginExceptionMapper.Error();
        error.cause = "authorization-failure";
        error.message = e.getMessage();
        return Response.status(403).entity(error).build();
    }
}
