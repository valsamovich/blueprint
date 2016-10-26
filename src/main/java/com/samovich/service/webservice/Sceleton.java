package com.samovich.service.webservice;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Filename webservice_dataconsistency
 * Created by Valery Samovich
 * Written on 7/14/16
 */

@Service
@Path("/")
public class Sceleton {

    @GET
    @Path("hello")
    @Produces({"application/json"})
    public Response getHours() {
        Map<String, Object> objectResponse = Maps.newLinkedHashMap();
        objectResponse.put("content", "Hello, from Spring Boot App!");
        return Response.ok(objectResponse).build();
    }

}
