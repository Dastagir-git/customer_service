package com.example.customer_service.service;

import com.example.customer_service.model.CustomerDto;
import com.example.customer_service.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public ResponseEntity<String> addCustomerService(CustomerDto customerDto){
        customerRepo.save(customerDto);
        return ResponseEntity.ok("Customer Added");
    }

    public ResponseEntity<CustomerDto> getCustomerServiceById(long id){
        Optional<CustomerDto> customerDto=customerRepo.findById(id);
        return ResponseEntity.ok(customerDto.get());
    }

    public ResponseEntity<String> deleteCustomerService(long id){
        customerRepo.deleteById(id);
        return ResponseEntity.ok("Customer Deleted");
    }

    public ResponseEntity<CustomerDto> getCustomerServiceByEmail(String email){
        CustomerDto customerDto= customerRepo.findCustomerDtoByEmail(email);
        return ResponseEntity.ok(customerDto);
    }

}
