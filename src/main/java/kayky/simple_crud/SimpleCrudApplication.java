package kayky.simple_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kayky.simple_crud.repository.CustomerRepository;
import kayky.simple_crud.service.CustomerService;

@SpringBootApplication
public class SimpleCrudApplication {

	@Bean
	public CustomerService customerService(CustomerRepository customerRepository) {
		return new CustomerService(customerRepository);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleCrudApplication.class, args);
	}

}
