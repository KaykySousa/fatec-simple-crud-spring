package kayky.simple_crud.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import kayky.simple_crud.exception.NotFoundException;
import kayky.simple_crud.model.Customer;
import kayky.simple_crud.repository.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) throw new NotFoundException();
        return customerRepository.save(customer);
    }

    public Customer patch(Customer customer) {
        Customer c = this.findById(customer.getId());

        String name = customer.getName();
        LocalDate birthdate = customer.getBirthdate();
        String phone = customer.getPhone();
        String address = customer.getAddress();

        if (name != null && !name.isBlank()) c.setName(name);
        if (birthdate != null) c.setBirthdate(birthdate);
        if (phone != null && !phone.isBlank()) c.setPhone(phone);
        if (address != null && !address.isBlank()) c.setAddress(address);

        return customerRepository.save(c);
    }

    public void deleteById(UUID id) {
        if (!customerRepository.existsById(id)) throw new NotFoundException();
        customerRepository.deleteById(id);
    }
}
