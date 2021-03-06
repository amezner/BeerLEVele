/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import Exceptions.NoSuchATokenException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dnovak
 */
@Provider

public class NoSuchATokenExceptionMapper implements ExceptionMapper<NoSuchATokenException> {

    public static class Error {

        public String cause;
        public String message;
    }

    @Override

    public Response toResponse(NoSuchATokenException e) {
        LoginExceptionMapper.Error error = new LoginExceptionMapper.Error();
        error.cause = "token-failure";
        error.message = e.getMessage();
        return Response.status(401).entity(error).build();
    }
}
