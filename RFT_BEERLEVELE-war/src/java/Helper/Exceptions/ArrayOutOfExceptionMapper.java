/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author dnovak
 */
@Provider

public class ArrayOutOfExceptionMapper implements ExceptionMapper<ArrayIndexOutOfBoundsException> {

    public static class Error {

        public String cause;
        public String message;
    }

    @Override

    public Response toResponse(ArrayIndexOutOfBoundsException e) {
        LoginExceptionMapper.Error error = new LoginExceptionMapper.Error();
        error.cause = "failure";
        error.message = e.getMessage();
        return Response.status(400).entity(error).build();
    }

}
