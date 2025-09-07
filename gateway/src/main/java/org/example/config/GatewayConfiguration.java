package org.example.config;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.rewritePath;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.path;


@Configuration
public class GatewayConfiguration {
    @Bean
    public RouterFunction<ServerResponse> customRoutes(){
        return GatewayRouterFunctions.route("product-static")
                .route(path("/products"),http())
                .before(rewritePath("/products","/api/v1/products"))
                .before(uri("http://localhost:8081"))
                .build();
    }
}