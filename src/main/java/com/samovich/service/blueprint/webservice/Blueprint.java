/**
 * The MIT License (MIT)
 * Copyright (c) 2016 Valery Samovich
 * http://opensource.org/licenses/MIT
 */

package com.samovich.service.blueprint.webservice;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * This class consists general endpoint for quick start.
 * @author  Valery Samovich
 * @see     Map
 */

@Service
@Path("/")
public class Blueprint {

    @GET
    @Path("blueprint")
    @Produces({"application/json"})
    public Response getAppHello() {
        Map<String, Object> objectResponse = Maps.newLinkedHashMap();
        objectResponse.put(
                "Description",
                "Spring Boot CXF Client Application with JAX-RS");
        return Response.ok(objectResponse).build();
    }

}
