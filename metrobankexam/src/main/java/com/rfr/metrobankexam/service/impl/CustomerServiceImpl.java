package com.rfr.metrobankexam.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.rfr.metrobankexam.dto.CustomerDto;
import com.rfr.metrobankexam.dto.Response;
import com.rfr.metrobankexam.entity.Customer;
import com.rfr.metrobankexam.entity.Savings;
import com.rfr.metrobankexam.repository.CustomerRepo;
import com.rfr.metrobankexam.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepo customerRepo;

	@Override
	public Response addCustomer(CustomerDto customerDto) {

        Customer customer = new Customer();

        try {
	        if (customerDto.getAccountType() != null) customer.setAccountType(customerDto.getAccountType());
	        else {
	        	throw new IllegalArgumentException("Account Type is required field");
	        }
	        if (customerDto.getCustomerName() != null) customer.setCustomerName(customerDto.getCustomerName());
	        if (customerDto.getCustomerEmail() != null) customer.setCustomerEmail(customerDto.getCustomerEmail());
	        else {
	        	throw new IllegalArgumentException("Email is required field");
	        };
	        if (customerDto.getCustomerMobile() != null) customer.setCustomerMobile(customerDto.getCustomerMobile());
	        if (customerDto.getAddress1() != null) customer.setAddress1(customerDto.getAddress1());
	        if (customerDto.getAddress2() != null) customer.setAddress2(customerDto.getAddress2());
	        
	        Savings savings = new Savings();
	        
	        if (customerDto.getSavings().get(0).getAccountNumber() != null) savings.setAccountNumber(customerDto.getSavings().get(0).getAccountNumber());
	        if (customerDto.getSavings().get(0).getAccountType() != null) savings.setAccountType(customerDto.getSavings().get(0).getAccountType());
	        if (customerDto.getSavings().get(0).getAvailableBalance() != null) savings.setAvailableBalance(customerDto.getSavings().get(0).getAvailableBalance());
	        
	        customer.addSavings(savings);
	        
			// TODO Auto-generated method stub
	        Customer savedCustomer = customerRepo.save(customer);
			Long customerNumber = savedCustomer.getCustomerNumber();
			
	        String message = ("Customer account created");
	        return Response.builder()
	        		.customerNumber(customerNumber)
	                .transactionStatusCode(201)
	                .transactionStatusDescription(message)                
	                .build();
        } catch (IllegalArgumentException e) {
        	return Response.builder()
                    .transactionStatusCode(201)
                    .transactionStatusDescription(e.getMessage())                
                    .build();
        }
	}
	
    @Override
    public Response findCustomerNumber(Long customerNumber) {
        Customer customer = customerRepo.findByCustomerNumber(customerNumber);
        try {
		    if(customer == null){
		        throw new NoSuchElementException("Customer not found");
		    }
		    return Response.builder()
		    		.customer(customer)
		            .transactionStatusCode(302)
		            .transactionStatusDescription("Customer Account found")                
		            .build();
        } catch (NoSuchElementException e) {
        	return Response.builder()
                    .transactionStatusCode(401)
                    .transactionStatusDescription(e.getMessage())                
                    .build();        	
        }

    }
	
	
	
}
