package hu.arpad.harcsa.reactive.domain.customer;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table(CustomerEntity.CUSTOMER_TABLE)
@AccessType(AccessType.Type.FIELD)
public class CustomerEntity {
    public static final String CUSTOMER_TABLE = "CUSTOMER";
    @Id
    @Column
    private long id;

    @Column
    private String name;

    private CustomerEntity(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static CustomerEntity of(final long id, final String name) {
        return new CustomerEntity(id, name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CustomerEntity() {
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CustomerEntity that = (CustomerEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
