package com.redhat;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {

    @Inject
    GreetingGenerator greetingGenerator;

    @ConfigProperty(name = "greeting.message")
    String message;

    @GET
    public String hello() {
        Log.debug("hello called");
        return message;
    }

    @POST
    @Transactional
    public String helloSomeone(final String name) {
        Log.debug("helloSomeone called with name: " + name);
        String greetingMessage = greetingGenerator.generateGreeting(name);
        Greeting greeting = new Greeting(name, greetingMessage);
        greeting.persist();
        return greetingMessage;
    }
}
