package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        return customerOptional.orElseThrow(() -> new NoSuchElementException());
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    public Customer findByPetsId(Long petId) {
        return this.customerRepository.findByPetsId(petId);
    }

    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
