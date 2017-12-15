/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dnovak
 */
@Provider

public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

    public static class Error {

        public String cause;
        public String message;
    }

    @Override
    public Response toResponse(Exception e) {
        LoginExceptionMapper.Error error = new LoginExceptionMapper.Error();
        error.cause = "failure";
        error.message = e.getMessage();
        e.printStackTrace();
        return Response.status(400).entity(error).build();
    }

}
