package hu.arpad.harcsa.reactive.domain.customer;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<CustomerEntity,Long> {
}
