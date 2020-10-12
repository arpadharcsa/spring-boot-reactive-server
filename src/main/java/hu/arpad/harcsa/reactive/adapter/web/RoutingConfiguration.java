package hu.arpad.harcsa.reactive.adapter.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfiguration {

    private static final String CUSTOMER_ENDPOINT = "customer";

    @Bean
    public RouterFunction<?> customerRouting(CustomerHandler handler) {
        return route()
            .path("/" + CUSTOMER_ENDPOINT, builder -> builder
                .nest(accept(MediaType.APPLICATION_JSON), b -> b
                    .GET("/{id}", handler::findOne)
                    .GET("", handler::findAll)))
            .build();
    }
}
