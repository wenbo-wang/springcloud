package com.example.webflux.rest.route;

import com.example.webflux.rest.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutesConfiguration {

    @Bean
    public RouterFunction<ServerResponse> userRouteFunction(UserHandler userHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/users/{id}"),userHandler::getUser);
//                .andRoute(RequestPredicates.GET("/api/users/{id}"),userHandler::getUser);
    }

//    @Bean
//    public RouterFunction<ServerResponse> personRouteFunction(PersonHandler personHandler) {
//        return RouterFunctions.route(RequestPredicates.GET("/api/users/{id}"),personHandler::getPerson);
////                .andRoute(RequestPredicates.GET("/api/users/{id}"),userHandler::getUser);
//    }
}
