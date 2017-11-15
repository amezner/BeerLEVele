/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import java.security.GeneralSecurityException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dnovak
 */
@Provider

public class DefaultExceptionMapper implements ExceptionMapper<Exception> {
    @Context
    private HttpHeaders headers;
    
    @Override
    public Response toResponse(Exception e) {
        return Response.status(400).entity(e.getMessage()).type(headers.getMediaType()).build();
    }
    
}