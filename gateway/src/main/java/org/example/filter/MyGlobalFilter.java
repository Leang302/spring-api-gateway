//package org.example.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class MyGlobalFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//      return chain.filter(
//              exchange.mutate().request(
//                   builder -> builder.header("testing_header","header_value")
//              ).build()
//      ).doOnEach(voidSignal -> {
//          exchange.getResponse().beforeCommit(() -> {
//              exchange.getResponse().getHeaders().add("key","new value");
//              return Mono.empty();
//          });
//      });
//    }
//
//    @Override
//    public int getOrder() {
//        return -100;
//    }
//}
//
