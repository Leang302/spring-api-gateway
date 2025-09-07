//package org.example.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Component
//public class LoggingGlobalFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println("Request URL: " + exchange.getRequest().getURI());
//        System.out.println("Request Method: " + exchange.getRequest().getMethod());
//        System.out.println("Request headers:");
//        exchange.getRequest().getHeaders()
//                .forEach((k, v) -> System.out.println(k + " = " + v));
//
//        return chain.filter(exchange).doOnSuccess(aVoid -> {
//            // Log response status
//            System.out.println("Response Status Code: " + exchange.getResponse().getStatusCode());
//            exchange.getResponse().getHeaders()
//                    .forEach((k, v) -> System.out.println(k + " : " + v));
//        });
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}
