package hu.arpad.harcsa.reactive.adapter.web;

import hu.arpad.harcsa.reactive.domain.customer.Customer;
import hu.arpad.harcsa.reactive.domain.customer.CustomerEntity;
import hu.arpad.harcsa.reactive.domain.customer.CustomerRepository;
import hu.arpad.harcsa.reactive.domain.customer.ImmutableCustomer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
class DefaultCustomerHandler implements CustomerHandler{
    private final CustomerRepository repository;

    public DefaultCustomerHandler(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<ServerResponse> findOne(ServerRequest request) {
        final long id = Integer.parseInt(request.pathVariable("id"));
        final Mono<ImmutableCustomer> customer = repository.findById(id)
            .map(CustomerEntity::getName)
            .map(ImmutableCustomer::of);
        return ok().body(customer, ImmutableCustomer.class);
    }

    @Override
    public Mono<ServerResponse> findAll(final ServerRequest request) {
        final Flux<Customer> elements = repository.findAll()
            .map(CustomerEntity::getName)
            .map(ImmutableCustomer::of);
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(elements, ImmutableCustomer.class);
    }

}
