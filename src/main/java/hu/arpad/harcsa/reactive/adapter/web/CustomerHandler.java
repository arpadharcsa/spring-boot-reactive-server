package hu.arpad.harcsa.reactive.adapter.web;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface CustomerHandler {
    Mono<ServerResponse> findOne(ServerRequest request);
    Mono<ServerResponse> findAll(final ServerRequest request);
}
