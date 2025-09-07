//package org.example.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StaticRouteConfig {
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//
//                //  Exact /products -> /api/v1/products
//                .route("product-root", r -> r
//                        .path("/products")
//                        .filters(f -> f
//                                .rewritePath("^/products$", "/products")
//                                .prefixPath("/api/v1")
//                        )
//                        .uri("http://localhost:8081"))
//
//                //  /products/** -> /api/v1/products/{**}
//                .route("product-nested", r -> r
//                        .path("/products/**")
//                        .filters(f -> f
//                                .rewritePath("^/products/(?<segment>.*)$", "/products/${segment}")
//                                .prefixPath("/api/v1")
//                        )
//                        .uri("http://localhost:8081"))
//                .build();
//    }
//
//}
