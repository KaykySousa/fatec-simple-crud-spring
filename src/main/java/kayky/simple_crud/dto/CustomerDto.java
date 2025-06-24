package kayky.simple_crud.dto;

import java.time.LocalDate;

import kayky.simple_crud.model.Customer;

public record CustomerDto(
    String name,
    LocalDate birthdate,
    String phone,
    String address
) {
    public Customer toEntity() {
        return new Customer(null, name, birthdate, phone, address);
    }
}
