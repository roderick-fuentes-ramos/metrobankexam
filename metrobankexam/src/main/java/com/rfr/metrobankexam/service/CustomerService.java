package com.rfr.metrobankexam.service;

import com.rfr.metrobankexam.dto.CustomerDto;
import com.rfr.metrobankexam.dto.Response;
import com.rfr.metrobankexam.dto.SavingsDto;

public interface CustomerService {

	Response addCustomer(CustomerDto customerDto);
	Response findCustomerNumber(Long customerNumber);
}
