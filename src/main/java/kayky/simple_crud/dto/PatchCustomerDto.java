package kayky.simple_crud.dto;

import java.time.LocalDate;
import java.util.Optional;

import kayky.simple_crud.model.Customer;

public record PatchCustomerDto(
    Optional<String> name,
    Optional<LocalDate> birthdate,
    Optional<String> phone,
    Optional<String> address
) {
    public Customer toEntity() {

        return new Customer(
            null,
            name.orElse(null),
            birthdate.orElse(null),
            phone.orElse(null),
            address.orElse(null)
        );
    }
}
