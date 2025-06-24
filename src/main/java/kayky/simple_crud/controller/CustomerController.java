package kayky.simple_crud.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kayky.simple_crud.dto.CustomerDto;
import kayky.simple_crud.dto.ErrorDto;
import kayky.simple_crud.dto.PatchCustomerDto;
import kayky.simple_crud.exception.NotFoundException;
import kayky.simple_crud.model.Customer;
import kayky.simple_crud.service.CustomerService;

@RestController
@RequestMapping("v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody CustomerDto customer) {

        return customerService.save(customer.toEntity());
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
        @RequestBody CustomerDto customer,
        @PathVariable UUID id
    ) {
        Customer entity = customer.toEntity();
        entity.setId(id);

        return customerService.update(entity);
    }

    @PatchMapping("/{id}")
    public Customer patchCustomer(
        @RequestBody PatchCustomerDto customer,
        @PathVariable UUID id
    ) {
        Customer entity = customer.toEntity();
        entity.setId(id);

        return customerService.patch(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteById(id);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleCustomerNotFound(NotFoundException e) {
        return new ErrorDto(HttpStatus.NOT_FOUND, "Customer was not found");
    }
}
