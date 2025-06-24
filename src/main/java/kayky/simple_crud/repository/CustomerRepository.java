package kayky.simple_crud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import kayky.simple_crud.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {}
