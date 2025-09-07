//package org.example.filter.factory;
//
//import org.example.args.Config;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomPathGatewayFilterFactory extends AbstractGatewayFilterFactory<Config> {
//
//    public CustomPathGatewayFilterFactory() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return ((exchange, chain) ->
//            chain.filter(
//                    exchange.mutate()
//                            .request(builder -> builder.path(config.getNewPath()))
//                            .build()
//             ));
//    }
//
//}
