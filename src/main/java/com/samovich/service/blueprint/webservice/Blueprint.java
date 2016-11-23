package com.samovich.service.blueprint.webservice;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * General endpoint for quick start.
 * Filename Skeleton.java
 * Created by Valery Samovich
 * Written on 7/14/16
 */

@Service
@Path("/")
public class Blueprint {

    @GET
    @Path("blueprint")
    @Produces({"application/json"})
    public Response getAppHello() {
        Map<String, Object> objectResponse = Maps.newLinkedHashMap();
        objectResponse.put("Spring Boot", "v1.3.5.RELEASE");
        return Response.ok(objectResponse).build();
    }

}
