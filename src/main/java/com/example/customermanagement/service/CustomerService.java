package com.example.customermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customermanagement.dto.CustomerDTO;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        return repository.save(customer);
    }
    
    public Customer updateCustomer(Long id, Customer updated) {
        return repository.findById(id).map(customer -> {
            customer.setName(updated.getName());
            customer.setEmail(updated.getEmail());
            customer.setPhone(updated.getPhone());
            customer.setAddress(updated.getAddress());
            return repository.save(customer);
        }).orElse(null);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    public boolean deleteCustomerIfExists(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

