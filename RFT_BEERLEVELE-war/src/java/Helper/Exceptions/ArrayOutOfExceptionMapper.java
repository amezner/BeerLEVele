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
public class ArrayOutOfExceptionMapper implements ExceptionMapper<ArrayIndexOutOfBoundsException>{
  @Context
    private HttpHeaders headers;
    public Response toResponse(ArrayIndexOutOfBoundsException e) {
        return Response.status(400).entity(e.getMessage()).type(headers.getMediaType()).build();
    }
    
}
