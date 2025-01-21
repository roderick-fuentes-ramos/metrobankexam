package com.rfr.metrobankexam.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rfr.metrobankexam.entity.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int transactionStatusCode;
    private String transactionStatusDescription;
    private Long customerNumber;
    private Customer customer;
}
