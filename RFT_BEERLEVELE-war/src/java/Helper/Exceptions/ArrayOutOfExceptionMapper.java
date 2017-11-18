/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author dnovak
 */

@Provider
<<<<<<< HEAD
public class ArrayOutOfExceptionMapper implements ExceptionMapper<ArrayIndexOutOfBoundsException>{
  @Context
    private HttpHeaders headers;
  @Override
=======
public class ArrayOutOfExceptionMapper implements ExceptionMapper<ArrayIndexOutOfBoundsException> {

    public static class Error {

        public String cause;
        public String message;
    }

>>>>>>> e7551925c391ee9a7ed35eff50911bf62eb11eb8
    public Response toResponse(ArrayIndexOutOfBoundsException e) {
         LoginExceptionMapper.Error error = new LoginExceptionMapper.Error();
        error.cause = "failure";
        error.message = e.getMessage();
        return Response.status(400).entity(e.getMessage()).build();
    }

}
