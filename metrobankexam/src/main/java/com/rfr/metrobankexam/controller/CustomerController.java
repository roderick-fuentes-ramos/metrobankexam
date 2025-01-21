package com.rfr.metrobankexam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfr.metrobankexam.dto.CustomerDto;
import com.rfr.metrobankexam.dto.Response;
import com.rfr.metrobankexam.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/account")
    public ResponseEntity<Response> addCustomer(@RequestBody CustomerDto customerDto){
    	
        return ResponseEntity.ok(customerService.addCustomer(customerDto));
    }
    
    @GetMapping("/account/{customerNumber}")
    public ResponseEntity<Response> getCustomerByCustomerNumber(@PathVariable Long customerNumber){
        return ResponseEntity.ok(customerService.findCustomerNumber(customerNumber));
    }
}
