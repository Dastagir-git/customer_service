package com.example.customer_service.repository;

import com.example.customer_service.model.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDto, Long> {

    @Query(value = "SELECT * FROM customer_dto WHERE email= ?1", nativeQuery = true)
    CustomerDto findCustomerDtoByEmail(String email);
}
