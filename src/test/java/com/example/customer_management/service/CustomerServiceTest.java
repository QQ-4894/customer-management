package com.example.customer_management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.customermanagement.dto.CustomerDTO;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.repository.CustomerRepository;
import com.example.customermanagement.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService service;

    @Test
    void testGetAllCustomer() {
        Customer c1 = new Customer();
        c1.setName("山田太郎");
        c1.setEmail("tato@example.com");
        c1.setPhone("090-1234-5678");
        c1.setAddress("東京都港区");

        when(repository.findAll()).thenReturn(List.of(c1));
        var result = service.getAllCustomers();

        assertEquals(1, result.size());
        assertEquals("山田太郎", result.get(0).getName());
    }

    @Test
    void testGetCustomerById_found() {
        Customer c1 = new Customer();
        c1.setName("加藤楓");
        c1.setEmail("tato@example.com");
        c1.setPhone("090-1234-5678");
        c1.setAddress("東京都港区");
        
        when(repository.findById(1L)).thenReturn(Optional.<Customer>of(c1));
        var result = service.getCustomerById(1L);
        assertEquals("加藤楓", result.getName());
    }

    @Test
    void testGetCustomerById_notFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> service.getCustomerById(99L));
    }

    @Test
    void testCreateCustomer() {
        CustomerDTO input = new CustomerDTO();
        input.setName("田中圭介");
        input.setEmail("tato@example.com");
        input.setPhone("090-1234-5678");
        input.setAddress("東京都港区");
        
        Customer saved = new Customer();
        saved.setId(1L);
        saved.setName("田中圭介");
        saved.setEmail("tato@example.com");
        saved.setPhone("090-1234-5678");
        saved.setAddress("東京都港区");
        
        when(repository.save(any(Customer.class))).thenReturn(saved);
        var result = service.createCustomer(input);
        assertNotNull(result.getId());
        assertEquals("田中圭介", result.getName());
    }

    @Test
    void testUpdateCustomer_found() {
        Customer existing = new Customer();
        existing.setId(1L);
        existing.setName("Old");
        existing.setEmail("tato@example.com");
        existing.setPhone("090-1234-5678");
        existing.setAddress("東京都港区");
        
        Customer updated = new Customer();
        updated.setName("New");
        updated.setEmail("tato@example.com");
        updated.setPhone("090-1234-5678");
        updated.setAddress("愛知県名古屋市");

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        var result = service.updateCustomer((1L), updated);
        assertEquals("New", result.getName());
        assertEquals("愛知県名古屋市", result.getAddress());
    }

    @Test
    void testUpdateCustomer_notFound() {
        Customer updated = new Customer();
        updated.setName("New");
        updated.setEmail("tato@example.com");
        updated.setPhone("090-1234-5678");
        updated.setAddress("愛知県名古屋市");

        when(repository.findById(99L)).thenReturn(Optional.empty());

        var result = service.updateCustomer(99L, updated);
        assertNull(result);
    }

    @Test
    void testDeleteCustomer() {
        doNothing().when(repository).deleteById(1L);

        service.deleteCustomer(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
