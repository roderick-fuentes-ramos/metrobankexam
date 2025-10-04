package com.rfr.metrobankexam.service.impl;

import java.util.ArrayList;
import java.util.List;
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

            if (customerDto.getSavings() != null) {
                customerDto.getSavings().forEach(savingsDto -> {
                    Savings savings = new Savings();

                    if (savingsDto.getAccountNumber() != null)
                        savings.setAccountNumber(savingsDto.getAccountNumber());

                    if (savingsDto.getAccountType() != null)
                        savings.setAccountType(savingsDto.getAccountType());

                    if (savingsDto.getAvailableBalance() != null)
                        savings.setAvailableBalance(savingsDto.getAvailableBalance());

                    customer.addSavings(savings);
                });
            }
	        
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
                    .transactionStatusCode(400)
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
                    .customerNumber(customer.getCustomerNumber())
                    .customerName(customer.getCustomerName())
                    .customerMobile(customer.getCustomerMobile())
                    .address1(customer.getAddress1())
                    .address2(customer.getAddress2())
                    .savings(customer.getSavings())
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
