package com.example.webfluxannotation.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping("users/{id}")
    public Mono<String> getUser(@PathVariable  String id) {
        System.out.println(id);
        return Mono.just(id);
    }

    @GetMapping("user/{name}")
    public Flux<String> getUsers(@PathVariable String name) { // 一般 flux 返回集合 当然还有很多功能没写
        System.out.println(name);
        return Flux.just(name);
    }
}
