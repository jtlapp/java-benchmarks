package com.jtlapp.jvmvsjs.joobymvc.controllers;

import io.jooby.annotation.GET;
import io.jooby.annotation.Path;
import io.jooby.annotation.PathParam;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
@Path("/api")
public class ApiController {

    @Inject
    ScheduledExecutorService scheduler;

    @GET
    @Path("/sleep/{millis}")
    public CompletableFuture<String> sleep(@PathParam int millis) {
        var future = new CompletableFuture<String>();

        scheduler.schedule(() -> {
            future.complete("");
        }, millis, TimeUnit.MILLISECONDS);

        return future;
    }
}
