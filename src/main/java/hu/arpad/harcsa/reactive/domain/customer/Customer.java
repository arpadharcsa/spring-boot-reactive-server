package hu.arpad.harcsa.reactive.domain.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize
public interface Customer {

    @JsonProperty
    @Value.Parameter
    String name();
}
