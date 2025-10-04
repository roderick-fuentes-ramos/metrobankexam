package com.rfr.metrobankexam.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rfr.metrobankexam.entity.Customer;

import com.rfr.metrobankexam.entity.Savings;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int transactionStatusCode;
    private String transactionStatusDescription;
    private Long customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private String accountType;

    private List<Savings> savings;
}
