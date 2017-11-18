/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper.Exceptions;

import javax.security.auth.login.LoginException;
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
public class LoginExceptionMapper implements ExceptionMapper<LoginException> {

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(LoginException exception) {
        return Response.status(403).entity(exception.getMessage()).type(headers.getMediaType()).build();
    }
}
