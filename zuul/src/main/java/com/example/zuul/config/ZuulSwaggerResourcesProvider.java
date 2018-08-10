package com.example.zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: springboot
 * @description: Retrieves all registered services Swagger resources
 * @author: liujc
 * @create: 2018-07-27 15:23
 */
@Component
@Primary
public class ZuulSwaggerResourcesProvider implements SwaggerResourcesProvider {

    private final Logger log = LoggerFactory.getLogger(ZuulSwaggerResourcesProvider.class);

    private final RouteLocator routeLocator;

    public ZuulSwaggerResourcesProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();

        //Add the default swagger resource that correspond to the gateway's own swagger doc
        resources.add(swaggerResources("default", "/v2/api-docs"));

        //Add the registered microservices swagger docs as additional swagger resources
        List<Route> routes = routeLocator.getRoutes();
        routes.forEach(route -> {
            log.info("------------------------{},{},{}",route.getId(),route.getFullPath(),route.getPath());
            resources.add(swaggerResources(route.getId(), route.getFullPath().replace("**", "v2/api-docs")));
        });

        return resources;
    }


//    @Override
//    public List<SwaggerResource> get() {
//        List<SwaggerResource> swaggerResources = new LinkedList<>();
//        // 添加本地接口
//        swaggerResources.add(swaggerResources("default","/v2/api-docs"));
//        properties.getRoutes().values().forEach(route -> {
//            log.info("------------------------{},{},{}",route.getServiceId(),route.getLocation(),route.getPath());
//            swaggerResources.add(swaggerResources(route.getServiceId(),"/" + route.getServiceId() + "/v2/api-docs"));
//        });
//        return swaggerResources;
//    }

    private  SwaggerResource swaggerResources(String name , String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return  swaggerResource;
    }
}
