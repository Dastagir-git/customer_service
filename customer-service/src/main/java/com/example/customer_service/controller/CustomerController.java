package com.example.customer_service.controller;

import com.example.customer_service.model.CustomerDto;
import com.example.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto){
       return customerService.addCustomerService(customerDto);
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable long id){
        return customerService.getCustomerServiceById(id);

    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id){
        return customerService.deleteCustomerService(id);

    }

    @GetMapping("/getCustomer")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@RequestParam("email") String email){
        return customerService.getCustomerServiceByEmail(email);

    }


}
