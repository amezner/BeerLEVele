/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */

public class CORSFilter implements ContainerResponseFilter {
    @Override
    public ContainerResponse filter(ContainerRequest request,
            ContainerResponse response) {

        response.getHttpHeaders().add(
                "Access-Control-Allow-Origin", "*"
        );
        response.getHttpHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, authtoken"
        );
        response.getHttpHeaders().add(
                "Access-Control-Allow-Credentials", "true"
        );
        response.getHttpHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD"
        );

        return response;
    }

}
