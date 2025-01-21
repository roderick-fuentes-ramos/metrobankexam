package com.rfr.metrobankexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rfr.metrobankexam.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByCustomerNumber(Long customerNumber);
}
