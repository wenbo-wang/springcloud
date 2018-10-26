package com.example.webflux.rest.handler;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        // ...
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just("sass"),String.class);
    }
}
